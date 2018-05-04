package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {

		BbsDTO bbsdto = new BbsDTO();
		
		
		
			System.out.println("BbsReplyCmd: "+request.getParameter("bNum"));
		bbsdto.setbNum(Integer.parseInt(request.getParameter("bNum")));
			System.out.println("BbsReplyCmd: "+request.getParameter("bNum"));
		bbsdto.setbName(request.getParameter("bName"));
			System.out.println("BbsReplyCmd: "+request.getParameter("bName"));
		bbsdto.setbTitle(request.getParameter("bTitle"));
			System.out.println("BbsReplyCmd: "+request.getParameter("bTitle"));
		bbsdto.setbContent(request.getParameter("bContent"));
			System.out.println("BbsReplyCmd: "+request.getParameter("bContent"));
		bbsdto.setbGroup(Integer.parseInt(request.getParameter("bGroup")));
			System.out.println("BbsReplyCmd: "+request.getParameter("bGroup"));
		bbsdto.setbStep(Integer.parseInt(request.getParameter("bStep")));
			System.out.println("BbsReplyCmd: "+request.getParameter("bStep"));
		bbsdto.setbIndent(Integer.parseInt(request.getParameter("bIndent")));
			System.out.println("BbsReplyCmd: "+request.getParameter("bIndent"));
		
		BbsDAO bbsdao = BbsDAO.getInstance();
		bbsdao.reply(bbsdto);
	}

}
