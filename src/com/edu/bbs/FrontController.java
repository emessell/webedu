package com.edu.bbs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.cmd.BCommand;
import com.edu.bbs.cmd.BbsAfterpageCmd;
import com.edu.bbs.cmd.BbsDeleteCmd;
import com.edu.bbs.cmd.BbsListCmd;
import com.edu.bbs.cmd.BbsModifyCmd;
import com.edu.bbs.cmd.BbsPrepageCmd;
import com.edu.bbs.cmd.BbsViewCmd;
import com.edu.bbs.cmd.BbsWriteCmd;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
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
      // TODO Auto-generated method stub
	   System.out.println("doPost 호출");
       actionDo(request, response);
   }
   
   private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("actionDo 호출");
         
      request.setCharacterEncoding("utf-8");
      BCommand command= null;
      String viewPage = null;  //view 이동경로
      
      String uri = request.getRequestURI();
      String conPath = request.getContextPath();
      String cmd = uri.substring(conPath.length());
      
      System.out.println(uri);
      System.out.println(conPath);
      System.out.println(cmd);
      
      switch (cmd) {
      
      //글쓰기 이동
      case "/bbs/write_view.do":
         viewPage = "/bbs/write_form.jsp";
         break;
         
      //글쓰기 등록
      case "/bbs/write.do":
         command = new BbsWriteCmd();
         command.execute(request, response);
         viewPage = "/bbs/list.do";   //게시판 목록 가져오기 
         break;
      
      //글 목록 가져오기
      case "/bbs/list.do":
         command = new BbsListCmd();
         command.execute(request, response);
         viewPage = "/bbs/list.jsp";   //게시판 목록으로 이동
         break;

       //글 가져오기
      case "/bbs/view.do":
         command = new BbsViewCmd();
         command.execute(request, response);
         viewPage = "/bbs/view.jsp";   //글로 이동
         break;
         
       //글 수정할 페이지
      case "/bbs/modify_form.do":
         command = new BbsViewCmd();
         command.execute(request, response);
         viewPage = "/bbs/modify_form.jsp";   //수정할 수 있는 페이지 보여주기 
         break;
         
       //글 수정한 뒤 페이지
      case "/bbs/modify.do":
         command = new BbsModifyCmd();
         command.execute(request, response);
         viewPage = "/bbs/view.do";   //수정 완료 
         break;
         
         
       //글 삭제
      case "/bbs/delete.do":
    	  command = new BbsDeleteCmd();
    	  command.execute(request, response);
    	  viewPage = "/bbs/list.do";   //삭제 완료 
    	  break;
    	  
    	  //이전글
      case "/bbs/prepage.do":
         command = new BbsPrepageCmd();
         command.execute(request, response);
         viewPage = "/bbs/view.do";   //글로 이동
         break;
         
         //다음글
      case "/bbs/afterpage.do":
         command = new BbsAfterpageCmd();
         command.execute(request, response);
         viewPage = "/bbs/view.do";   //글로 이동
         break;


      default:
         break;
      }
      
//      요청디스패치 방식(RequestDispatcher)
//      Server 또는 JSP 에서 요청을 받은 후 다른 컴퍼넌트로 요청을 위임할 수 있다.
//      위임할 떄 요청객체(request)를 동일하게 전달 할 수 있다.
      
      RequestDispatcher dispat =request.getRequestDispatcher(viewPage);
      dispat.forward(request, response);
      
      }
}