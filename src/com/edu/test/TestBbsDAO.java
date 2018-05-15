package com.edu.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

class TestBbsDAO {

	/*@Test
	void test() {
		RecordCriteria pc = new RecordCriteria(1,10);
		
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.list(pc.getStartRecord(), pc.getEndRecord());
		
		for(BbsDTO bbsdto: alist) {
			System.out.println(bbsdto);
		}
	}*/
	
	/*@Test
	   void test3() {
	      
	      BbsDAO bbsdao = BbsDAOimpl.getInstance();
	      ArrayList<BbsDTO> alist = bbsdao.searchList("제목 내용", "15",1,10);
	      for(BbsDTO bbsdto: alist) 
	         System.out.println(bbsdto);
	      
	   }*/
	
	@Test
	   void test4() {
	      
	      BbsDAO bbsdao = BbsDAOimpl.getInstance();
	      int count = bbsdao.getSearchListCount("작성자", "15");
	         System.out.println(count);
	      }
	
	

}
