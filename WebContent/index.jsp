<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<html>
	<head>
		<title>在线用户</title>
	</head>
	<body>
		<form action="index.jsp" method="post">
			用户名：
			<input type="text" name="username" />
			<input type="submit" value="登  陆" />
		</form>
		<%
			String username = request.getParameter("username");

			if (username != null && username.trim().length()!=0 ) 
			{
				session.removeAttribute("username");//每次设置username属性前，先删除已存在的username属性，这样每次触发的都是attributeAdded事件，否则会触发attributeReplaced事件
				session.setAttribute("username", username);
			}
			else
			{
				username = (String)session.getAttribute("username");//如果username为空，这取得当前会话中的username
			}
			
			ArrayList online = (ArrayList)application.getAttribute("online");
		%>
		
		<a href="logout.jsp?username=<%=username%>">注销最新登录用户</a>
		<p>
		<h3>
			当前客户端的最新登录用户:
			<%=username%>	
			<br>
			所有客户端已登录的在线用户数：
			<%=online.size()%>
		</h3>
		<h2>在线用户列表：</h2>
		<hr>
		<%
			Object[] objects = (Object[])online.toArray();
			for (int i = 0; i < objects.length; i++) 
			{		
				Object object = objects[i];
				String user = (String)object;
		%>
				<%=user%>
		<br>
		<%
			}
		%>
	</body>
</html>
