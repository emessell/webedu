package com.edu.test;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

class TestBbsDAO {

	@Test
	void test() {
		RecordCriteria pc = new RecordCriteria(1,10);
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> alist = bbsdao.list(pc.getStartRecord(), pc.getEndRecord());
		
		for(BbsDTO bbsdto: alist) {
			System.out.println(bbsdto);
		}
	}

}
