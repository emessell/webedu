package com.edu.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

public class ReReplyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RbbsDTO rbbsdto = new RbbsDTO();

		rbbsdto.setRnum(Integer.parseInt(request.getParameter("Rnum")));
		rbbsdto.setRname(request.getParameter("Rname"));
		rbbsdto.setRcontent(request.getParameter("Rcontent"));

		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();

		rbbsdao.reply(rbbsdto);
	}
}
