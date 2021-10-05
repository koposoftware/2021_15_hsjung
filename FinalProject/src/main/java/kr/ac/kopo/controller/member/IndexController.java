package kr.ac.kopo.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.javamodeling.common.ResultPojoList;
import com.javamodeling.component.AES256Cipher;

import kr.ac.kopo.common.BaseController;
import kr.ac.kopo.common.GlobalConstants;
import kr.ac.kopo.pojo.Account;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.service.AccountService;
import kr.ac.kopo.service.AuctionService;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ProductService;


@Controller
@RequestMapping("/index")
public class IndexController extends BaseController {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AuctionService auctionService;
	
	@GetMapping("/login")
	public String loginPage() {
	
		return "member/login/login";
	}
	
	@GetMapping("/hana")
	public String hanaMain() {
		
		return "member/main";
	}
	
	@GetMapping("/hanaLogin")
	public String hanaLogin() {
		
		return "member/login/hanaLogin";
	}	
	
	@GetMapping("")
	public ModelAndView main(ModelAndView modelAndView, HttpServletRequest request) {
	
		Member memberChk = new Member();
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);
		
		
		memberChk = memberService.obtainMemberByPk(member);//LINE :: 세션 정보로 확인하면, 추가 해도 널로 체크된다.
		
		if(memberChk.getMemberMainAccount() == null) {//사용자의 메인 계좌 보유 여부 확인
			
			ResultPojoList accountResult = accountService.obtainAccountByMember(memberChk);
			
			
			
			modelAndView.addObject("member", memberChk);
			modelAndView.addObject("accounts", accountResult.getList());
			modelAndView.setViewName("member/login/moreInformation");
			
		}else {
			
			//추천 알고리즘 영역
			ResultPojoList productRecommendList = new ResultPojoList();
			ResultPojoList auctionRecommendList = new ResultPojoList();
			ResultPojoList todayRecommendList = new ResultPojoList();
			
			productRecommendList = productService.selectProductRecommendList(memberChk);
			auctionRecommendList = auctionService.selectAuctionRecommendList(memberChk);
			todayRecommendList = productService.selectTodayRecommendList(memberChk);
			
			modelAndView.addObject("member", memberChk);
			modelAndView.addObject("todayRecommendList", todayRecommendList.getList());
			modelAndView.addObject("auctionList", auctionRecommendList.getList());
			modelAndView.addObject("productList", productRecommendList.getList());
			
			modelAndView.setViewName("member/index");
		}
		
		return modelAndView;
	}
	

	
	
	
	@PostMapping("/login")
	public ModelAndView login(Member member , ModelAndView modelAndView, HttpSession session) {
		
		member.setPwd(AES256Cipher.encrypt(member.getPwd(), null));
		Member memberResult = memberService.login(member);
		
		if(memberResult.getResultCode() == 0L) {
			String msg = "아이디 또는 패스워드가 잘못되었습니다.";
			
			modelAndView.addObject("msg", msg);
			modelAndView.setViewName("member/login/login");
			
			return modelAndView;
		}
		
		session.setAttribute(GlobalConstants.MEMBER_OBJECT, memberResult); // redirect로 인해, session에 미리 등록해준다.
		
		String dest = (String)session.getAttribute("dest");
		if(dest != null) { // 로그인 페이지 전에 다른 
			session.removeAttribute("dest"); // dest session은 이제 필요 없기 때문에, 세션 제거
			
			modelAndView.setViewName("redirect:"+dest);  // 로그인 전 페이지로 redirect
			
			return modelAndView;
		}
		
		modelAndView.setViewName("redirect:/index/");
		return modelAndView; // 스프링에서는 redirect 시 , 포워드 처럼 루트패스 다음으로 경로를 잡아줌
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(SessionStatus sessionStatusm, HttpSession session, ModelAndView modelAndView) { // @SessionAttributes 어노테이션을 쓰면 SessionStatus로 사용해야함
		
		/*
		 * System.out.println(sessionStatus.isComplete()); sessionStatus.setComplete();
		 * // isCOmplete를 false -> true로 바꿔주는 방식
		 * System.out.println(sessionStatus.isComplete());
		 */
		session.invalidate(); // @SessionAttributes 시 ,사용 불가
		modelAndView.setViewName("redirect:/index/hana");
		
		return modelAndView;
		
	}
}
