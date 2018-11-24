<%@ page language="java" pageEncoding="utf-8"%>

<html>
	<head>
		<title>用户注销</title>		
	</head>

	<body>
		<%	
			String username = request.getParameter("username");
		    if(username.equals("null"))
		    {
		%>
		    	<h3>当前无最新登录用户，无法注销！</h3>
		<%
		    }
		    else
		    {
				session.invalidate();//注销用户会话
		%>
			<h3>用户会话注销成功！</h3>
		<%	
		    }
		%>
		<a href="index.jsp">返回</a>
	</body>
</html>