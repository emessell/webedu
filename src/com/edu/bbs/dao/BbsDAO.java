package com.edu.bbs.dao;

import java.util.ArrayList;

import com.edu.bbs.dto.BbsDTO;

public interface BbsDAO {
   
	//글쓰기
	public void write(BbsDTO bbsdto);
	//글목록 가져오기
	public ArrayList<BbsDTO> list_2();
	//페이징
	public ArrayList<BbsDTO> list(int startRec, int endRec);
	//글 보여주기
	public BbsDTO view(int bNum);
	//글 수정하기
	public BbsDTO modify(BbsDTO bbsdto);
	//글 삭제
	public void delete(BbsDTO bbsdto);
	//원글 읽어오기
	public BbsDTO replyView(String bNum);
	//답글 등록하기
	public void reply(BbsDTO bbsdto);
	
	// 원글 읽어오기
	public ArrayList<BbsDTO> pagelist();

	public int getListCount();

	// 검색한 글목록가져오기
	ArrayList<BbsDTO> searchList(String option, String search, int startRow, int endRow);

	// 검색한 글 전체 수 가져오기
	int getSearchListCount(String option, String search);
}