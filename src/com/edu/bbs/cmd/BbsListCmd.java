package com.edu.bbs.cmd;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
//		int numPerPage = Integer.parseInt(request.getParameter("numPerPage"));
		RecordCriteria pc = new RecordCriteria(reqPage, 10);
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		ArrayList<BbsDTO> list = bbsdao.list(pc.getStartRecord(), pc.getEndRecord());
		request.setAttribute("list", list);
	}
}
