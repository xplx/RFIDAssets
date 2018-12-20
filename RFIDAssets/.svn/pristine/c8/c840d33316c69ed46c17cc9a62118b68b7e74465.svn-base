<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>

</head>
<body>
${picpath }
<img src="${picpath }"/>
<table>
  <c:forEach items="${list}" var="u" >
   <tr align=center bordercolor="black">
    <td>${u.ASSET_TYPE}</td>
    <td>${u.COUNT}</td>
  
   </tr>
  </c:forEach>
 </table>
 
 <form method="post" action="toLibrary/addToLibrary" enctype="multipart/form-data">
	选择一个文件:
	<input type="file" name="uploadFile" />
	<input type="text" name="asset_Id">
	<input type="text" name="username">
	<br/><br/>
	<input type="submit" value="上传" />
</form>
<a href="./JPush/JPush"> xiazai</a>
</body>

</html>
