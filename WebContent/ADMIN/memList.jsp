<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.edu.*" %>
<%@ page import ="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 50%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}

</style>
</head>
<body>
<%
   request.setCharacterEncoding("utf-8");
   MemberDAO mdao = MemberDAO.getInstance();
   ArrayList<MemDTO> arr = mdao.getMemberAll();
   // totalCount : 전체 레코드 수
   // countList : 한 페이지에 출력될 게시물 수(20개~)
   // countPage : 한 화면에 출력될 페이지 수 (1 2 3 4 5 6 7 8 9 10)
   // page : 현재 페이지 번호
   int totalCount = arr.size();
   
   int countList = 20;
   
   int totalPage = totalCount / countList;
   if(totalCount%countList > 0) {
      totalPage++;
   }
%>
   <table>
      <tr>
         <td></td>
         <td>ID</td>
         <td>PASSWD</td>
         <td>NAME</td>
         <td>BIRTH</td>
         <td>PHONE</td>
         <td>CDATE</td>
         <td>UDATE</td>
      </tr>
      <%
      for(int i =0; i<totalCount; i++) {
      %>
      <tr>
         <td><%=i+1 %></td>
         <td>
            <%=arr.get(i).getId() %>
         </td>
         <td>
            <%=arr.get(i).getPasswd() %>
         </td>
         <td>
            <%=arr.get(i).getName() %>
         </td>
         <td>
            <%=arr.get(i).getBirth() %>
         </td>
         <td>
            <%=arr.get(i).getPhone() %>
         </td>
         <td>
            <%=arr.get(i).getCdate() %>
         </td>
         <td>
            <%=arr.get(i).getUdate() %>
         </td>
      </tr>
         <%
      }
         %>
   </table>
   <br>
</body>
</html>