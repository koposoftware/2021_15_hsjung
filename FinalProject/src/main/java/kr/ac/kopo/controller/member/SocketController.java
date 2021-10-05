package kr.ac.kopo.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javamodeling.util.DateUtils;

import kr.ac.kopo.common.COLUMN;
import kr.ac.kopo.common.GlobalConstants;
import kr.ac.kopo.pojo.Member;
import kr.ac.kopo.pojo.PostIt;
import kr.ac.kopo.pojo.Product;
import kr.ac.kopo.service.MemberService;
import kr.ac.kopo.service.ProductService;

@Controller
@RequestMapping("/socket")
public class SocketController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/list")
	public ModelAndView socketList(ModelAndView modelAndView) {
		
		modelAndView.addObject("socketPort", GlobalConstants.SOCKET_PORT);
		modelAndView.setViewName("member/rtcSocket/socketList");
		
		return modelAndView;
	}
	
	@RequestMapping("/guest/{roomNo}")
	public ModelAndView socketUserPage(ModelAndView modelAndView,PostIt postIt, @PathVariable("roomNo") String roomNo) {
		

		PostIt findRoomNo = new PostIt();
		
		postIt.setPostItPk(Long.parseLong(roomNo));
	   findRoomNo = memberService.findRoomPkSwitch(postIt);
	   
	   modelAndView.addObject("socketPort", GlobalConstants.SOCKET_PORT);
	   modelAndView.addObject("requestedRoom", findRoomNo.getPostItPk());
		
	   modelAndView.setViewName("member/rtcSocket/guest");
	  
	   return modelAndView;
	}
	
	@RequestMapping("/host/{roomNo}")
	public ModelAndView testModelAndView2(ModelAndView modelAndView, PostIt postIt, HttpServletRequest request, @PathVariable("roomNo") String roomNo )	{
	   
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute(GlobalConstants.MEMBER_OBJECT);//사용자 정보 조회
		Product productResult = new Product();
		PostIt postItResult = new PostIt();

		postIt.setIsRead(COLUMN.POST_IT_STATUS.REPLY);
		postIt.setInputDate(DateUtils.getCurrentTime());
		postIt.setPostItPk(Long.parseLong(roomNo));//방번호와 pk가 동일
		postItResult = memberService.sendPostIt(postIt);
		
		productResult.setProductSq(postItResult.getProduct().getProductSq());
		
		productResult = productService.obtainProductByPk(productResult);
		
		modelAndView.addObject("postItList", postItResult);
		modelAndView.addObject("product", productResult);
	    modelAndView.addObject("socketPort", GlobalConstants.SOCKET_PORT);
	    modelAndView.addObject("requestedRoom", postItResult.getPostItPk());
	
	   modelAndView.setViewName("member/rtcSocket/host");
		  
	   return modelAndView;
	}
	

	
}
