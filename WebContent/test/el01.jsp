<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${100}
	<br /> ${11.99}
	<br /> ${"문자열1"}
	<br /> ${'문자열2' }
	<br /> ${false}
	<br /> ${true}
	<br />
	<hr />
	${10+10 }
	<br /> ${10-20 }
	<br /> ${10*2 }
	<br /> ${10>20 }
	<br />
	<hr />
	${10<20 }
	<br /> ${10>10 ? 1:2 }
	<br /> ${(10<20) || (10>20)}
	<br />
</body>
</html>