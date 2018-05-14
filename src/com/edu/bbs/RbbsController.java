package com.edu.bbs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.cmd.RbbsDeleteCmd;
import com.edu.bbs.cmd.RbbsListCmd;
import com.edu.bbs.cmd.RbbsModifyCmd;
import com.edu.bbs.cmd.RbbsWriteCmd;

/**
 * Servlet implementation class RbbsController
 */
@WebServlet("/rbbs/*")
public class RbbsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RbbsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo 호출");
		
		response.setContentType("text/html;charSet=utf-8");
	   request.setCharacterEncoding("UTF-8");
      BCommand command = null;
      
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String cmd = uri.substring(conPath.length());
      
      System.out.println(uri);
      System.out.println(conPath);
      System.out.println(cmd);
      
      switch (cmd) {
		// 댓글 등록
		case "/rbbs/write":
			command = new RbbsWriteCmd();
			command.execute(request, response);
			break;
		
		// 댓글 목록가져오기
		case "/rbbs/list":
			command = new RbbsListCmd();
			command.execute(request, response);
			break;

		// 댓글 수정
		case "/rbbs/modify":
			command = new RbbsModifyCmd();
			command.execute(request, response);
			break;

		// 댓글 삭제
		case "/rbbs/delete":
			command = new RbbsDeleteCmd();
			command.execute(request, response);
			break;

		default:
			break;
		}
	}
}