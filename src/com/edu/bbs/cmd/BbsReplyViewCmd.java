package com.edu.bbs.cmd;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.dao.BbsDAO;
import com.edu.bbs.dto.BbsDTO;

public class BbsReplyViewCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request,HttpServletResponse response) {

			String bNum = request.getParameter("bNum");
			
			BbsDAO bbsdao = BbsDAO.getInstance();
			BbsDTO bbsdto = bbsdao.replyView(bNum);

			request.setAttribute("replyView", bbsdto);

	}
}
