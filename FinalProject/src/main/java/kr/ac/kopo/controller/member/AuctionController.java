package kr.ac.kopo.controller.member;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.javamodeling.common.Pagination;
import com.javamodeling.common.ResultPojoList;
import com.javamodeling.util.DateUtils;

import kr.ac.kopo.common.BaseController;
import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.common.GlobalConstants;
import kr.ac.kopo.pojo.AuctionProductImg;
import kr.ac.kopo.pojo.AuctionTransaction;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransaction;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.AuctionProduct;
import kr.ac.kopo.service.AccountService;
import kr.ac.kopo.service.AuctionService;

@Controller
@RequestMapping("/member")
public class AuctionController extends BaseController {

	@Autowired
	private AuctionService auctionService;
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 경매 상품 조회 메소드
	 * @param modelAndView
	 * @param pagination
	 * @return
	 */
	@GetMapping("/auctionList")
	public ModelAndView auctionList(ModelAndView modelAndView, Pagination pagination) {
	
		ResultPojoList resultValueList = auctionService.searchAuctionList(pagination);
		
		modelAndView.addObject("auction", resultValueList.getList());
		modelAndView.addObject("pagination",generatePagination("/member/auctionList", resultValueList.getPagination()));
		
		modelAndView.setViewName("member/auction/auctionList");
		
		return modelAndView;
	}
	
	/**
	 * 경매 상품 카테고리 조회
	 * @param modelAndView
	 * @param pagination
	 * @param productCategory
	 * @param request
	 * @return
	 */
	@GetMapping("/auctionListByCategory")
	public ModelAndView auctionListByCategory(ModelAndView modelAndView, Pagination pagination, ProductCategory productCategory, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		
		ResultPojoList resultValueList = auctionService.searchAuctionListByCategory(pagination, productCategory, member);
		
		modelAndView.addObject("auction", resultValueList.getList());
		modelAndView.addObject("pagination",generatePagination("/member/auctionList", resultValueList.getPagination()));
		
		modelAndView.setViewName("member/auction/auctionList");

		return modelAndView;
	}
	
	/**
	 * 제품 상세 조회 (view_cnt + 1)
	 * @param modelAndView
	 * @param produdct
	 * @return
	 */
	@GetMapping("/auctionDetail")
	public ModelAndView auctionDetail(ModelAndView modelAndView, AuctionProduct auctionProduct, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		ResultPojoList accountResult = accountService.obtainAccountByMember(member);
		
		AuctionProduct auctionProductResult = auctionService.obtainAuctionProductByPk(auctionProduct);
		
		modelAndView.addObject("accounts", accountResult.getList());
		modelAndView.addObject("auctionProduct", auctionProductResult);
		
		modelAndView.setViewName("member/auction/auctionDetail");

		return modelAndView;
	}
	
	
	/**
	 * 상품 추가 페이지
	 * @return
	 */
	@GetMapping("/auctionAdd")
	public String productAddPage() {
	
		return "member/auction/auctionAdd";
	}
	
	/**
	 * 상품 추가 메소드
	 * @param member
	 * @param productCategory
	 * @param auctionProduct
	 * @param ifile
	 * @param pagination
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/auctionAdd")
	public String productAdd(Member member, ProductCategory productCategory, AuctionProduct auctionProduct, HanaFile ifile, Pagination pagination, HttpServletRequest request) throws Exception {
		
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = mRequest.getFileNames();

		MultipartFile mFile = null;
		Member memberResult = null;
		AuctionProduct productResult = null;
		HanaFile fileResult = null;
		AuctionProductImg productImgResult = null;
		List<HanaFile> hanaFileResultList = new ArrayList<HanaFile>();//필요한 객체 초기화
				
		List<MultipartFile> imgFiles = ifile.getFileNameI();
		auctionProduct.setInputDate(DateUtils.getCurrentTime());
		auctionProduct.setMember(member);
		auctionProduct.setProductCategory(productCategory);
		auctionProduct.setStatus(COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		auctionProduct.setViewCnt(COLUMN.DEFAULTSTATE);
		auctionProduct.setPriceNow(auctionProduct.getPriceMin());
		auctionProduct.setStartDate(DateUtils.getCurrentTime());
		auctionProduct.setIbchalja(member.getMemberSq());
		//상품 상태 셋팅
		
		if (imgFiles != null) {
			
			mFile = mRequest.getFile(iterator.next());				
			for (int i = 0; i < imgFiles.size(); i++) {//iterator돌리면서 해당 내용이 없으면 반복 종료

				if (imgFiles.get(i) == null) {
					break;
				} else {

					//mFile = mRequest.getFile(iterator.next());

					String folder="AUCTION"+auctionProduct.getAuctionProductName();
					String savedRoot = "AUCTION/" +folder;
					String saveFileName = saveImageFile(imgFiles.get(i),"/AUCTION", folder);//로컬에 파일 저장. 저장된파일 이름(변조된)이 반환
					
					HanaFile savedFiles = new HanaFile();	
					savedFiles.setFileName(imgFiles.get(i).getOriginalFilename());//원래 파일 이름
					savedFiles.setFileSavedFileName(savedRoot + "/" + saveFileName);//변경된 파일 이름
					savedFiles.setFileInputDate(DateUtils.getCurrentTime());//현재 시간
					savedFiles.setFileSize(imgFiles.get(i).getSize());//파일 사이즈
					savedFiles.setFileThumbnailFileName(savedRoot + "/T" + saveFileName);//파일 경로 + 변경된 파일이름
					
					hanaFileResultList.add(savedFiles);
				}
			}
		}
		productResult = auctionService.addAuctionProduct(hanaFileResultList, auctionProduct);

		return productResult.toResultJsonString();
	}
	
	@ResponseBody
	@PostMapping("/bidAuctionProduct")
	public String bidAuctionProduct(AuctionProduct auctionProduct, Member member) {
		
		AuctionProduct auctionProductResult = auctionService.modifyAuctionProduct(auctionProduct, member);
		//경매 입찰
		return auctionProductResult.toResultJsonString();
	}
	
	/**
	 * 제품 주문
	 * @param modelAndView
	 * @param produdct
	 * @return
	 */
	@PostMapping("/orderAuctionMaxPriceProduct")
	@ResponseBody
	public String orderAuctionProduct(AuctionTransaction auctionTransaction, AuctionProduct product, Account account, Member member) {

		AuctionProduct productResult = new AuctionProduct();	
		History history = new History();
		
		history.setChange(product.getPriceMax()+product.getMaxFee());
		history.setInputDate(DateUtils.getCurrentTime());
		history.setReceiverBankCode(1L);
		history.setField(null);
		history.setReceiverBankCode(1L);
		
		auctionTransaction.setInputDate(DateUtils.getCurrentTime());
		auctionTransaction.setPrice(0L);//LINE :: 초기화
		
		productResult.setInputDate(DateUtils.getCurrentTime());
		productResult = auctionService.addAuctionMaxPriceTransaction(auctionTransaction, product, account,member,history);

		return productResult.toResultJsonString();
	}
	
	
}
