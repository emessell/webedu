package com.edu.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;

public class GoodOrBadCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String rNum = request.getParameter("rNum");
		String goodOrBad = request.getParameter("goodOrBad");
		
		System.out.println(goodOrBad);
		
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		
		rbbsdao.goodOrBad(rNum, goodOrBad);

	}

}
