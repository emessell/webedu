package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsDeleteCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rNum = request.getParameter("rNum");
	      RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
	      rbbsdao.delete(rNum);

	}
}


