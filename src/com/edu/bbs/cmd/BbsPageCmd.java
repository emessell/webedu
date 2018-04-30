package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsPageCmd implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsDAO bbsdao = BbsDAO.getInstance();
		int bNum = Integer.parseInt(request.getParameter("bNum"));
		int np = Integer.parseInt(request.getParameter("np"));
		
		BbsDTO bbsdto = bbsdao.page(bNum,np);
		request.setAttribute("bbsdto", bbsdto);
	}

}
