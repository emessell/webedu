package com.edu.bbs.dto;

import java.sql.Date;

public class BbsDTO {

	private int bNum;			//게시글 번호
	private String bTitle;	//제목
	private String bId;		//작성자 ID
	private String bName;		//작성자 name
	private Date bCdate;		//
	private Date bUdate;		//
	private int bHit;			//조회수
	private String bContent;	//
	private int bGroup;			//
	private int bStep;			//
	private int bIndent;		//
	
	public BbsDTO() {}
	
	public BbsDTO(int bNum, String bTitle, String bId, String bName, Date bCdate, Date bUdate, int bHit,
			String bContent, int bGroup, int bStep, int bIndent) {
		super();
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bId = bId;
		this.bName = bName;
		this.bCdate = bCdate;
		this.bUdate = bUdate;
		this.bHit = bHit;
		this.bContent = bContent;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}
	
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public String getbTitle() {
		return bTitle;
	}
	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	public String getbId() {
		return bId;
	}
	public void setbId(String bId) {
		this.bId = bId;
	}
	public String getbName() {
		return bName;
	}
	public void setbName(String bName) {
		this.bName = bName;
	}
	public Date getbCdate() {
		return bCdate;
	}
	public void setbCdate(Date bCdate) {
		this.bCdate = bCdate;
	}
	public Date getbUdate() {
		return bUdate;
	}
	public void setbUdate(Date bUdate) {
		this.bUdate = bUdate;
	}
	public int getbHit() {
		return bHit;
	}
	public void setbHit(int bHit) {
		this.bHit = bHit;
	}
	public String getbContent() {
		return bContent;
	}
	public void setbContent(String bContent) {
		this.bContent = bContent;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
}
