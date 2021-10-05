package kr.ac.kopo.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.javamodeling.common.Pagination;
import com.javamodeling.common.ResultPojoList;
import com.javamodeling.util.DateUtils;
import com.javamodeling.util.StringUtils;

import kr.ac.kopo.common.BaseController;
import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.common.GlobalConstants;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.History;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.PostIt;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.pojo.ProductTransaction;
import kr.ac.kopo.service.AccountService;
import kr.ac.kopo.service.AuctionService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ProductService;


@Controller
@RequestMapping("/member")
public class MemberController extends BaseController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AuctionService auctionService;
	
	/**
	 * 마이페이지 조회 (세션에 로그인한 회원 정보 출력)
	 */
	@GetMapping("/mypage")
	public ModelAndView main(ModelAndView modelAndView,HttpServletRequest request, Pagination pagination) {
	
		HttpSession session = request.getSession();

		ProductTransaction productTransaction = new ProductTransaction();
		productTransaction.setTransactionType("SE");
		
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		
		ResultPojoList accountResult = accountService.obtainAccountByMember(member);
		ResultPojoList processingProduct = productService.selectMemberProductListByStatus(pagination, member, productTransaction);
		ResultPojoList processingSellingProduct = productService.selectSellingProductListByStatus(pagination, member, productTransaction);
		ResultPojoList sellingProduct = productService.selectSellerMemberProductListByStatus(pagination, member);
		
		ResultPojoList selledProduct = productService.selectSelledProductList(pagination, member, productTransaction);
		ResultPojoList buyedProduct = productService.selectBuyedProductList(pagination, member, productTransaction);
		ResultPojoList postIt = memberService.searchPostItForMember(member);
		ResultPojoList ripple = memberService.searchProductRipple(member);
		ResultPojoList zzim = memberService.searchCartList(member);
		
		
		Long countBuy = memberService.countBuy(member);
		Long countSell = memberService.countSell(member);
		Long countPost = memberService.countPost(member);
		
		modelAndView.addObject("accounts", accountResult.getList());
		modelAndView.addObject("processingProduct", processingProduct.getList());
		modelAndView.addObject("processingSellingProduct", processingSellingProduct.getList());
		modelAndView.addObject("sellingProduct", sellingProduct.getList());
		
		modelAndView.addObject("selledProduct", selledProduct.getList());
		modelAndView.addObject("buyedProduct", buyedProduct.getList());
		modelAndView.addObject("postItList", postIt.getList());
		modelAndView.addObject("socketPort", GlobalConstants.SOCKET_PORT);
		
		modelAndView.addObject("countPost", countPost);
		modelAndView.addObject("countBuy", countBuy);
		modelAndView.addObject("countSell", countSell);
		modelAndView.addObject("ripple", ripple);
		modelAndView.addObject("zzim", zzim);
		 
		modelAndView.setViewName("member/mypage/mypage");
		
		return modelAndView;
	}
	
	/**
	 * 회원 거래 계좌 등록
	 * @param modelAndView
	 * @param productTransaction 거래 내역 트랜젝셔 (SQ 필요)
	 * @return
	 */
	@GetMapping("/addMemberAccount")
	public ModelAndView addMemberAccount(ModelAndView modelAndView, HttpServletRequest request, Account account) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		
		member = memberService.addMemberAccount(member,account);
		session.invalidate();
		modelAndView.setViewName("member/mypage/mypage");
		
		return modelAndView;
	}
	
	
	/**
	 * 경매 상품 마이페이지 리스트 조회 (+AJAX)
	 * @param modelAndView
	 * @param request
	 * @param pagination
	 * @return
	 */
	@PostMapping("/selectAuctionMyPage")
	public ModelAndView selectAuctionMyPage(ModelAndView modelAndView, HttpServletRequest request, Pagination pagination) {
	
		HttpSession session = request.getSession();

		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		
		ResultPojoList biddingAuction = auctionService.selectMemberAuctionBidList(pagination, member);
		ResultPojoList processingAuction = auctionService.selectMemberAuctionList(pagination, member);
		ResultPojoList sellingAuction = auctionService.selectSellerMemberAuctionList(pagination, member);
		
		ResultPojoList selledAuction = auctionService.selectSelledAuctionList(pagination, member);
		ResultPojoList buyedAuction = auctionService.selectBuyedAuctionList(pagination, member);
		
		modelAndView.addObject("biddingAuction", biddingAuction.getList());
		modelAndView.addObject("processingAuction", processingAuction.getList());
		modelAndView.addObject("sellingAuction", sellingAuction.getList());
		
		modelAndView.addObject("selledAuction", selledAuction.getList());
		modelAndView.addObject("buyedAuction", buyedAuction.getList());
		
		modelAndView.setViewName("member/mypage/selectAuctionMyPage");
		
		return modelAndView;
	}
	
	
	/**
	 * 중고 상품 마이페이지 리스트 조회 (+AJAX)
	 * @param modelAndView
	 * @param request
	 * @param pagination
	 * @return
	 */
	@PostMapping("/selectProductMyPage")
	public ModelAndView selectProductMyPage(ModelAndView modelAndView, HttpServletRequest request, Pagination pagination) {
	
		HttpSession session = request.getSession();

		ProductTransaction productTransaction = new ProductTransaction();
		productTransaction.setTransactionType("SE");
		
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		
		ResultPojoList processingProduct = productService.selectMemberProductListByStatus(pagination, member, productTransaction);
		ResultPojoList sellingProduct = productService.selectSellerMemberProductListByStatus(pagination, member);
		
		ResultPojoList selledProduct = productService.selectSelledProductList(pagination, member, productTransaction);
		ResultPojoList buyedProduct = productService.selectBuyedProductList(pagination, member, productTransaction);
		
		modelAndView.addObject("processingProduct", processingProduct.getList());
		modelAndView.addObject("sellingProduct", sellingProduct.getList());
		
		modelAndView.addObject("selledProduct", selledProduct.getList());
		modelAndView.addObject("buyedProduct", buyedProduct.getList());
		
		modelAndView.setViewName("member/mypage/selectProductMyPage");
		
		return modelAndView;
	}
	
	/**
	 * 마이페이지 사용자가 판매중인 물건 상태 상세 조회  (상품 정보 + 트랜젝션 정보 )
	 */
	@GetMapping("/productSellingStatusDetail")
	public ModelAndView productSellingStatusDetail(ModelAndView modelAndView, Product product, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);//사용자 정보 조회
		
		Product productResult = new Product();
		
		productResult = productService.obtainProductTransactionWithProductForSeller(product,member);
		
		modelAndView.addObject("product",productResult);
		modelAndView.setViewName("member/mypage/productSellingStatusDetail");
		
		return modelAndView;
	}
	
	/**
	 * 마이페이지 사용자가 구매중인 물건 상세 조회 (상품 정보 + 트랜젝션 정보 )
	 */
	@GetMapping("/productbuyingStatusDetail")
	public ModelAndView productbuyingStatusDetail(ModelAndView modelAndView, Product product, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);//사용자 정보 조회
		
		Product productResult = new Product();
		
		productResult = productService.obtainProductWithTransactionByProduct(product, member);
		
		modelAndView.addObject("product",productResult);
		modelAndView.setViewName("member/mypage/productBuyingStatusDetail");
		
		return modelAndView;
		
	}
	
	
	/**
	 * 운송장 추가
	 * @param modelAndView
	 * @param productTransaction 거래 내역 트랜젝셔 (SQ 필요)
	 * @return
	 */
	@PostMapping("/addUnsongjang")
	public ModelAndView addUnsongjang(ModelAndView modelAndView, ProductTransaction productTransaction) {
		
		ProductTransaction productResult = new ProductTransaction();
		
		productResult = productService.addUnsongJang(productTransaction);
		
		modelAndView.setViewName("redirect:/member/mypage");
		
		return modelAndView;
	}
	
	/**
	 * 안심거래 종료
	 * @param modelAndView
	 * @param productTransaction 거래 내역 트랜젝셔 (SQ 필요)
	 * @return
	 */
	@PostMapping("/securePaymentClose")
	public ModelAndView securePaymentClose(ModelAndView modelAndView, ProductTransaction productTransaction) {
		
		ProductTransaction productTransactionResult = new ProductTransaction();
		History history = new History();
		
		history.setInputDate(DateUtils.getCurrentTime());
		history.setReceiverBankCode(1L);
		history.setField(null);
		history.setTask("입금");
		
		productTransactionResult = productService.securePaymentClose(productTransaction, history);
		
		modelAndView.setViewName("redirect:/member/mypage");
		
		return modelAndView;
	}

	@PostMapping("/sendPostIt")
	public ModelAndView sendPostIt(ModelAndView modelAndView, PostIt postIt, Product product, HttpServletRequest request) {
		
		PostIt postItResult = new PostIt();
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);//사용자 정보 조회
		
		postIt.setSenderMemberPk(member.getMemberSq());
		postIt.setIsRead(COLUMN.NO);
		postIt.setInputDate(DateUtils.getCurrentTime());
		
		postItResult = memberService.sendPostIt(postIt, product);
		
		
		modelAndView.setViewName("redirect:/member/mypage");
		
		return modelAndView;
	}

}
