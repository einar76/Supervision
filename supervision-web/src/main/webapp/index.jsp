<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
HttpSession ses = request.getSession(); 

int min = 1000;
int max = 5000;
int randomNum = new Random().nextInt((max - min) + 1) + min;

try {
	Thread.sleep(randomNum);
} catch (InterruptedException e) {
	e.printStackTrace();
}


ses.invalidate();
%>
</body>
</html>