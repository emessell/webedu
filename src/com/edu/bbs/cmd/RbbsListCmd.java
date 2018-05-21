package com.edu.bbs.cmd;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.edu.bbs.PageCriteria;
import com.edu.bbs.RecordCriteria;
import com.edu.bbs.dao.RbbsDAO;
import com.edu.bbs.dao.RbbsDAOimpl;
import com.edu.bbs.dto.RbbsDTO;

public class RbbsListCmd implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int reReqPage = 0;
		PageCriteria pc = null;
		RecordCriteria rc = null;
		
		//요청 페이지가 없으면 1 페이지로 이동
		if(request.getParameter("reReqPage")==null || request.getParameter("reReqPage")=="") {
			reReqPage = 1;
		}else {
			reReqPage = Integer.parseInt(request.getParameter("reReqPage"));
		}
		
		int bNum = Integer.valueOf(request.getParameter("bNum"));
		RbbsDAO rbbsdao = RbbsDAOimpl.getInstance();
		ArrayList<RbbsDTO> alist = new ArrayList<>();
		StringBuffer str = new StringBuffer();
		
		rc = new RecordCriteria(reReqPage);
		alist = rbbsdao.list(bNum,rc.getStartRecord(),rc.getEndRecord());
		
		int replyTotalRec = rbbsdao.replyTotalRec(bNum);
		pc = new PageCriteria(rc, replyTotalRec);
		
		str.append("{ \"result\" : [");
		int i=0;
		for(RbbsDTO rbbsdto : alist) {
			i += 1;
			str.append("{\"RNUM\":\""+rbbsdto.getRnum() + "\",");
			str.append("\"BNUM\":\""+rbbsdto.getBnum() + "\",");
			str.append("\"RCDATE\":\""+rbbsdto.getRcdate() + "\",");
			str.append("\"RCONTENT\":\""+rbbsdto.getRcontent() + "\",");
			str.append("\"RNAME\":\""+rbbsdto.getRname() + "\",");
			str.append("\"RGOOD\":\""+rbbsdto.getRgood() + "\",");
			str.append("\"RINDENT\":\""+rbbsdto.getRindent() + "\",");

			
			if(alist.size()==i) {
				str.append("\"RBAD\":\""+rbbsdto.getRbad()+"\"}");
			} else {
				str.append("\"RBAD\":\""+rbbsdto.getRbad()+"\"},");
			}
		}
		str.append("] ,");
		
		str.append("\"pageCriteria\" :");
		str.append("{\"startPage\" :" 		+ pc.getStartPage() + ",");
		str.append("\"endPage\" :" 			+ pc.getEndPage() + ",");
		str.append("\"finalEndPage\" :" 	+ pc.getFinalEndPage() + ",");
		str.append("\"prev\" :" 			+ pc.isPrev() + ",");
		str.append("\"next\" :" 			+ pc.isNext() );
		str.append("} }");
		
		response.getWriter().write(str.toString());
	}

}