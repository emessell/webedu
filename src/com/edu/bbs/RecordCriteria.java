package com.edu.bbs;

public class RecordCriteria{

	private int reqPage;
	private int numPerPage;
	
	public RecordCriteria(int reqPage,int numPerPage) {
		this.reqPage = reqPage;
		this.numPerPage = numPerPage;
	}

	public int getReqPage() {
		return numPerPage;
		
	}

	public void setReqPage(int reqPage) {
		if(reqPage <=0 ) {
			this.reqPage=1;
			return;
		}
		this.reqPage=reqPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		if(numPerPage <=0 || numPerPage >100) {
			this.numPerPage=10;
			return;
		}
		this.numPerPage = numPerPage;
	}
	
	//시작 레코드 계산
	public int getStartRecord() {
		return ((this.reqPage-1)*this.numPerPage)+1;
	}
	
	//종료 레코드 계산
	public int getEndRecord() {
		return this.getStartRecord()+this.numPerPage-1;
	}
	
	@Override
	public String toString() {
		return "PageCriteria [reqPage="+reqPage+",numPerPage="+numPerPage+"]";
	}
	
}
	