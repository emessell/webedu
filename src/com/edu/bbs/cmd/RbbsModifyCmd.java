package com.edu.bbs.cmd;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;

public class RbbsModifyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rNum = request.getParameter("rNum");
	      String rContent = request.getParameter("rContent");
	      
	      RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
	      rbbsdao.modify(rNum, rContent);

	}

}
