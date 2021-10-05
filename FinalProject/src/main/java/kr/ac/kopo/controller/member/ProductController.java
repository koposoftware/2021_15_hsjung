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
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.HanaFile;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductCategory;
import kr.ac.kopo.pojo.ProductImg;
import kr.ac.kopo.pojo.ProductTransaction;
import kr.ac.kopo.pojo.ProductTransactionReview;
import kr.ac.kopo.service.AccountService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ProductService;

@Controller
@RequestMapping("/member")
public class ProductController extends BaseController{
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AccountService accountService;
	/**
	 * 상품 전체 출력 (상품 정보 + 썸네일 이미지)
	 * @param modelAndView
	 * @param pagination
	 * @return
	 */
	@GetMapping("/productList")
	public ModelAndView productList(ModelAndView modelAndView, Pagination pagination) {
		
		ResultPojoList resultValueList = productService.searchProductList(pagination);
		
		modelAndView.addObject("product", resultValueList.getList());
		modelAndView.addObject("pagination",generatePagination("/member/productList", resultValueList.getPagination()));
		
		modelAndView.setViewName("member/product/productList");

		return modelAndView;
	}
	
	/**
	 * 상품 해당 조건 출력 (상품 정보 + 썸네일 이미지)
	 * @param modelAndView
	 * @param pagination
	 * @return
	 */
	@GetMapping("/productListByCategory")
	public ModelAndView productListByCategory(ProductCategory productCategory,ModelAndView modelAndView, Pagination pagination, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);

		ResultPojoList resultValueList = productService.productListByCategory(pagination, productCategory, member);
		
		modelAndView.addObject("product", resultValueList.getList());
		modelAndView.addObject("pagination",generatePagination("/member/productListByCategory", resultValueList.getPagination()));
		
		modelAndView.setViewName("member/product/productList");

		return modelAndView;
	}
	
	/**
	 * 제품 상세 조회 (view_cnt + 1)
	 * @param modelAndView
	 * @param produdct
	 * @return
	 */
	@GetMapping("/productDetail")
	public ModelAndView productDetail(ModelAndView modelAndView, Product product,HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		Account memberAccount = accountService.obtainMemberAccount(member);
		
		//ResultPojoList accountResult = accountService.obtainAccountByMember(member);
		Product productResult = productService.obtainProductByPk(product);
		ResultPojoList productRipple = productService.obtainProductRippleByProduct(product);
		
		Long countBuy = memberService.countBuy(productResult.getMember());
		Long countSell = memberService.countSell(productResult.getMember());
		Long countPost = memberService.countPost(productResult.getMember());
		
		ResultPojoList productTransactionReview = new ResultPojoList();
		productTransactionReview = productService.searchProductTransactionRevice(product);
		
//		modelAndView.addObject("accounts", accountResult.getList());
		modelAndView.addObject("accounts", memberAccount);
		modelAndView.addObject("product", productResult);
		
		modelAndView.addObject("countPost", countPost);
		modelAndView.addObject("countBuy", countBuy);
		modelAndView.addObject("countSell", countSell);
		
		modelAndView.addObject("review",productTransactionReview);
		
		modelAndView.setViewName("member/product/productDetail");

		return modelAndView;
	}
	
	/**
	 * 제품 흥정가
	 * @param modelAndView
	 * @param produdct
	 * @return
	 */
	@GetMapping("/productDetailWithNego")
	public ModelAndView productDetailWithNego(ModelAndView modelAndView, Product product,HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		Account memberAccount = accountService.obtainMemberAccount(member);
		
		ResultPojoList accountResult = accountService.obtainAccountByMember(member);
		
		Product productResult = productService.obtainProductByPk(product);
		productResult.setPriceAfter(product.getPrice());
		productResult.setBarginAfter(COLUMN.PRODUCT.PRODUCT_CAN.CANNOT);
		//		modelAndView.addObject("accounts", accountResult.getList());
		modelAndView.addObject("accounts", memberAccount);
		modelAndView.addObject("product", productResult);
		
		modelAndView.setViewName("member/product/productDetailAfterBargin");

		return modelAndView;
	}
	
	/**
	 * 상품 추가 페이지
	 * @return
	 */
	@GetMapping("/productAdd")
	public ModelAndView productAddPage(ModelAndView modelAndView) {
		
		modelAndView.setViewName("member/product/productAdd");

		return modelAndView;
	}
	
	
	/**
	 * 상품 추가
	 */
	@ResponseBody
	@PostMapping("/productAdd")
	public String productAdd(Member member, ProductCategory productCategory, Product product, HanaFile ifile, Pagination pagination, HttpServletRequest request) throws Exception {
		
		MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
		Iterator<String> iterator = mRequest.getFileNames();

		MultipartFile mFile = null;
		Member memberResult = null;
		Product productResult = null;
		HanaFile fileResult = null;
		ProductImg productImgResult = null;
		List<HanaFile> hanaFileResultList = new ArrayList<HanaFile>();
				
		List<MultipartFile> imgFiles = ifile.getFileNameI();
		product.setInputDate(DateUtils.getCurrentTime());
		product.setMember(member);
		product.setProductCategory(productCategory);
		
		product.setStatus(COLUMN.PRODUCT.PRODUCT_STATUS.SELLING);
		product.setAmount(COLUMN.DEFAULTSTATE);
		product.setViewCnt(COLUMN.DEFAULTSTATE);
		
		
		if (imgFiles != null) {
			
			mFile = mRequest.getFile(iterator.next());				
			for (int i = 0; i < imgFiles.size(); i++) {

				if (imgFiles.get(i) == null) {
					break;
				} else {

					//mFile = mRequest.getFile(iterator.next());

					String folder="Product"+product.getProductName().toString();
					String savedRoot = "Product/" +folder;
					String saveFileName = saveImageFile(imgFiles.get(i),"/Product", folder);
					
					HanaFile savedFiles = new HanaFile();	
					savedFiles.setFileName(imgFiles.get(i).getOriginalFilename());//원래 파일 이름
					savedFiles.setFileSavedFileName(savedRoot + "/" + saveFileName);//변경된 파일 이름
					savedFiles.setFileInputDate(DateUtils.getCurrentTime());
					savedFiles.setFileSize(imgFiles.get(i).getSize());//파일 사이즈
					savedFiles.setFileThumbnailFileName(savedRoot + "/T" + saveFileName);//파일 경로 + 변경된 파일이름
					
					hanaFileResultList.add(savedFiles);
				}
			}
		}
		productResult = productService.addProduct(hanaFileResultList, product);

		return productResult.toResultJsonString();
	}

	/**
	 * 제품 주문
	 * @param modelAndView
	 * @param produdct
	 * @return
	 */
	@PostMapping("/orderProduct")
	@ResponseBody
	public String orderProduct(ProductTransaction productTransaction, Product product, Account account, Member member) {

		Product productResult = new Product();	
		History history = new History();
		
		history.setInputDate(DateUtils.getCurrentTime());
		history.setReceiverBankCode(1L);
		history.setChange(product.getPrice()+product.getFee());
		history.setField(null);
		history.setReceiverBankCode(1L);
		
		productTransaction.setTransactionDate(DateUtils.getCurrentTime());
		productTransaction.setTransactionPrice(0L);//LINE :: 초기화
		
		productResult.setInputDate(DateUtils.getCurrentTime());
		productResult = productService.addProductTransaction(productTransaction, product, account,member,history);

		sendSms("010-8756-2421", "010-8756-2421", "상품 주문이 성공적으로 되었습니다."+"\n상품명 : "+productResult.getProductName());
		
		return productResult.toResultJsonString();
	}


	/**
	 * 주문 확정
	 * @param modelAndView
	 * @param produdct
	 * @return
	 */
	@PostMapping("/confirmTransaction")
	public String confirmTransaction(ProductTransaction productTransaction, Product product, Account account, Member member) {

		Product productResult = new Product();	
		History history = new History();
		
		history.setInputDate(DateUtils.getCurrentTime());
		history.setReceiverBankCode(1L);
		history.setChange(product.getPrice()+product.getFee());
		history.setField(null);
		history.setReceiverBankCode(1L);
		
		productTransaction.setTransactionDate(DateUtils.getCurrentTime());
		productTransaction.setTransactionPrice(0L);//LINE :: 초기화
		
		productResult.setInputDate(DateUtils.getCurrentTime());
		productResult = productService.addProductTransaction(productTransaction, product, account,member,history);

		sendSms("010-8756-2421", "010-8756-2421", "상품 주문이 성공적으로 되었습니다.");
		
		return productResult.toResultJsonString();
	}
}
