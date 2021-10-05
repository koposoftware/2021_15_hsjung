package kr.ac.kopo.common;

import com.javamodeling.common.Pagination;
import com.javamodeling.component.StaticClass;
import com.javamodeling.controller.ControllerSupport;

public class BaseController extends ControllerSupport {


	/**
	 * 추후 페이징 처리를 한번에 하기 위한 메소드 
	 * @param urlPath
	 * @param pagination
	 * @return
	 */
	protected String generatePagination(String urlPath, Pagination pagination) {
		StringBuffer stringBuffer = new StringBuffer();
        
		stringBuffer.append(" 				<div class='col-lg-12'><div class='property-pagination'>");
		
		
		if (pagination.getCurrentPage() <= 1) {
			stringBuffer.append("			<a  class='icon' href='" + StaticClass.CTX_PATH + urlPath + "?currentPage=" + 1 + "'>");
		}
		else {
			stringBuffer.append("			<a  class='icon' chref='" + StaticClass.CTX_PATH + urlPath + "?currentPage=" + (pagination.getStartPageNo() - 1) + "'>");
		}
		stringBuffer.append("				<span class='arrow_left'></span>");
		stringBuffer.append("				</a>");

		for(int i = pagination.getStartPageNo(); i <= pagination.getEndPageNo(); i++) {
			
			if (i == pagination.getCurrentPage()) {
				stringBuffer.append("		<a href='#' style='background: #00C89E;color: #ffffff;'>" + i + "</a>");
			}
			else {
				stringBuffer.append("		<a href='" + StaticClass.CTX_PATH + urlPath + "?currentPage=" + i + "'>" + i + "</a>\n");
			}
		}

		if (pagination.getCurrentPage() >= pagination.getLastPageNo()) {
			// 현재 페이지가 총 페이지수보다 더 큰 경우
			stringBuffer.append("			<a  class='icon' href='" + StaticClass.CTX_PATH + urlPath + "?currentPage=" + pagination.getLastPageNo() + "'>");
		}
		else {
			stringBuffer.append("			<a class='icon' href='" + StaticClass.CTX_PATH + urlPath + "?currentPage=" + (pagination.getEndPageNo() + 1) + "'>");
		}
		stringBuffer.append("				<span class='arrow_right'></span></a> \n");

		/*
		 * stringBuffer.
		 * append("				<li class='page-item'><a class='page-link' href='" +
		 * StaticClass.CTX_PATH + urlPath + "?currentPage=" + pagination.getLastPageNo()
		 * + "'>\n"); stringBuffer.append("				Next </a></li>\n");
		 */
		stringBuffer.append(" 				 </ul> </nav>");
		return stringBuffer.toString();
	}
	
	protected String generateSearchPagination(String urlPath, Pagination pagination) {

		StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append(" 				<nav aria-label='Page navigation' style='float:right;'> <ul class='pagination'> <li class='page-item'>");
		stringBuffer.append("				<a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=1'>\n");
		stringBuffer.append("				<<");
		stringBuffer.append("				</a></li>\n");
		
		if (pagination.getCurrentPage() <= 1) {
			stringBuffer.append("			<li class='page-item'><a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=" + 1 + "'>\n");
		}
		else {
			stringBuffer.append("			<li class='page-item'><a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=" + (pagination.getStartPageNo() - 1) + "'>\n");
		}
		stringBuffer.append("				Previous\n");
		stringBuffer.append("				</a>&nbsp;&nbsp;</li>\n");
		

		for(int i = pagination.getStartPageNo(); i <= pagination.getEndPageNo(); i++) {
			
			if (i == pagination.getCurrentPage()) {
				stringBuffer.append("		<li class='page-item active'><a class='page-link' href='#'>" + i + "<span class=\"sr-only\">(current)</span></a></li>");
				
			}
			else {
				stringBuffer.append("		<li class='page-item'><a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=" + i + "'>" + i + "</a></li>\n");
			}
		}

		if (pagination.getCurrentPage() >= pagination.getLastPageNo()) {
			stringBuffer.append("			<li class='page-item'> <a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=" + pagination.getLastPageNo() + "'>\n");
		}
		else {
			stringBuffer.append("			<li class='page-item'> <a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=" + (pagination.getEndPageNo() + 1) + "'>\n");
		}
		stringBuffer.append("				Next</a></li> \n");
	
		stringBuffer.append("				<li class='page-item'><a class='page-link' href='" + StaticClass.CTX_PATH + urlPath + "&currentPage=" + pagination.getLastPageNo() + "'>\n");
		stringBuffer.append("				>> </a></li>\n");
		stringBuffer.append(" 				 </ul> </nav>");
		

		return stringBuffer.toString();
	}
	
	
	

	
}
