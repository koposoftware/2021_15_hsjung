package com.javamodeling.common;

import java.math.BigDecimal;

public class Pagination {


	//현재 보여질 페이지 번호
    private Integer currentPage = new Integer(1);

    //해당 총 리스트 갯수
    private Integer totalCount = new Integer(0);

    // 한 화면에 보여질 리스트 갯수
    private Integer viewCount = new Integer(20);
    
    // 한 화면에 보여질 페이지 갯수
    private Integer pageCount = new Integer(10);
    
    // 게시판 종류
    private String mainCategory;

	// 검색 조건(예:제목/내용/작성자 등등)
	private String searchCondition;
	
	// 검색 값
	private String searchValue;
	
	// 검색조건에 의한 조회인지 판단
	private String searchBy = "N";
	
	public Pagination() {
		
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount.intValue();
	}
	
	public void setTotalCount(BigDecimal totalCount) {
		this.totalCount = totalCount.intValue();
	}
	
	public Integer getViewCount() {
		return viewCount;
	}

	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchBy() {
		return searchBy;
	}

	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}

    public String getMainCategory() {
        return mainCategory;
    }

    public void setMainCategory(String mainCategory) {
        this.mainCategory = mainCategory;
    }

	public Integer getPageCount() {
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getLastPageNo() {
		
		int lastPageNo = Double.valueOf(Math.ceil(totalCount * 1.0 / viewCount)).intValue();
		
		return lastPageNo;
	}
	
	public int getFirstNo() {
		
		if (currentPage == null || currentPage <= 0) {
			currentPage = new Integer(1);
		}

		if (viewCount == null) {
			viewCount = new Integer(10);
		}

		int firstNo = (currentPage.intValue() - 1) * viewCount.intValue();

		return firstNo;
		
	}

	public int getStartPageNo() {
		
		int lastPageNo = Double.valueOf(Math.ceil(totalCount * 1.0 / viewCount)).intValue();
		
		int pageNo;
		
		if (lastPageNo <= currentPage) {
			pageNo = lastPageNo;
		}
		else {
			pageNo = currentPage;
		}
		
		int pageNoStart;
		
		if (pageNo == 0) {
			return 1;
		}
		
		if (pageNo % pageCount == 0) {
			
			pageNoStart = (pageNo / pageCount) * pageCount - pageCount + 1; 
		}
		else {
			pageNoStart = (pageNo / pageCount) * pageCount+ 1;
		}
		
		if (pageNoStart < 0) {
			
			pageNoStart = 0;
		}
		
		return pageNoStart;
		
	}
	
	public int getEndPageNo() {
		
		int lastPageNo = Double.valueOf(Math.ceil(totalCount * 1.0 / viewCount)).intValue();
		
		int pageNo;
		
		if (lastPageNo <= currentPage) {
			return lastPageNo;
		}
		else {
			pageNo = currentPage;
		}
		
		int pageNoEnd;
		
		if (pageNo % pageCount == 0) {
			
			pageNoEnd = (pageNo / pageCount) * pageCount;
		}
		else {
			pageNoEnd = (pageNo / pageCount) * pageCount + pageCount;
		}
		
		if (lastPageNo <= pageNoEnd) {
			return lastPageNo;
		} 
		else {
			return pageNoEnd;
		}

	}
}
