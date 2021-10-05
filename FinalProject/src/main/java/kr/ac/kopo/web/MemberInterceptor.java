package kr.ac.kopo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.ac.kopo.common.GlobalConstants;
import kr.ac.kopo.pojo.Member;


public class MemberInterceptor extends HandlerInterceptorAdapter  {


	@Override
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, 
							 Object handler) throws Exception {
		
			Member member= (Member)request.getSession().getAttribute(GlobalConstants.MEMBER_OBJECT);
			
			if (member != null) {
				
				return true;
			}
			else {
				String responsePath = (String) request.getServletContext().getContextPath() + "/index/login";
				
				response.sendRedirect(responsePath);
				
				return false;
				
			}
			
		}
	
}
