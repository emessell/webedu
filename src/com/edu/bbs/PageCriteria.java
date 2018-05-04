package com.edu.bbs;

public class PageCriteria {
	private int pageNumPerPage=10;
	private int curPage;
	private int startPage;
	private int endPage;
	private int totalRec;
	private int finalEndPage;
	private boolean prev;
	private boolean next;
	private RecordCriteria recordCriteria;
	
	public void setPageNumPerPage(int pageNumPerPage) {
		this.pageNumPerPage = pageNumPerPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = endPage-pageNumPerPage+1;
	}
	public void setEndPage(int endPage) {
		this.endPage = (int) Math.ceil((curPage/(double)pageNumPerPage))*pageNumPerPage;
	}
	public void setTotalRec(int totalRec) {
		this.totalRec = totalRec;
	}
	public void setFinalEndPage(int finalEndPage) {
		this.finalEndPage = totalRec/pageNumPerPage;
	}
	public void setPrev(boolean prev) {
		this.prev = startPage==1?false:true;
	}
	public void setNext(boolean next) {
		this.next = (endPage * pageNumPerPage) > totalRec ? false:true;
	}
	public int getPageNumPerPage() {
		return pageNumPerPage;
	}
	public int getCurPage() {
		return curPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public int getTotalRec() {
		return totalRec;
	}
	public int getFinalEndPage() {
		return finalEndPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public boolean isNext() {
		return next;
	}
	public RecordCriteria getRecordCriteria() {
		return recordCriteria;
	}
	@Override
	public String toString() {
		return "PageCriteria [pageNumPerPage=" + pageNumPerPage + ", curPage=" + curPage + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", totalRec=" + totalRec + ", finalEndPage=" + finalEndPage + ", prev="
				+ prev + ", next=" + next + ", recordCriteria=" + recordCriteria + "]";
	}
	
	
}
