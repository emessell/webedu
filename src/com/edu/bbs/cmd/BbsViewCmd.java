package com.edu.bbs.cmd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsViewCmd implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BbsDAO bbsdao = BbsDAO.getInstance();
		BbsDTO aview = bbsdao.view(Integer.parseInt(request.getParameter("bNum")));
		request.setAttribute("view", aview);
	}

}
