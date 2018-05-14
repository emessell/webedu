package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dao.BbsDAOimpl;
import com.edu.bbs.dto.BbsDTO;

public class BbsModifyCmd implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDTO bbsdto = new BbsDTO();
		BbsDAO bbsdao = BbsDAOimpl.getInstance();
		
		bbsdto.setbTitle(request.getParameter("bTitle"));
		bbsdto.setbContent(request.getParameter("bContent"));
		bbsdto.setbNum(Integer.parseInt(request.getParameter("bNum")));
		
		bbsdao.modify(bbsdto);
	}

	
	
}
