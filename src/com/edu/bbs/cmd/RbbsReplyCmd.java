package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsReplyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RbbsDTO rbbsdto = new RbbsDTO();

		rbbsdto.setRnum(Integer.parseInt(request.getParameter("rNum")));
		rbbsdto.setRname(request.getParameter("rName"));
		rbbsdto.setRcontent(request.getParameter("rContent"));

		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();

		rbbsdao.reply(rbbsdto);
	}
}
