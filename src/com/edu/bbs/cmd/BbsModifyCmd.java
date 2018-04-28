package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsModifyCmd implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BbsDTO bbsdto = new BbsDTO();
		BbsDAO bbsdao = BbsDAO.getInstance();
		String Num = request.getParameter("bNum");
		int bNum = Integer.parseInt(Num);
		
		bbsdto.setbContent(request.getParameter("bContent"));
		bbsdto.setbNum(bNum);
		
		bbsdao.modify(bbsdto);
	}

	
	
}
