package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsPrepageCmd implements BCommand{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bNum = Integer.valueOf(request.getParameter("bNum"));

		BbsDTO bbsdto = new BbsDTO();
		BbsDAO page = BbsDAO.getInstance();
		
		int bNum2 = page.prepage(bNum);
		request.setAttribute("prepage", bNum2);
		System.out.println(bNum2);
	}

}
