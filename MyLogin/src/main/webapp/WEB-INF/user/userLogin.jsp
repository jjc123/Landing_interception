<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${error!=null}">
    <font color="red">${error}</font>
</c:if>
<form action="${pageContext.request.contextPath}/login.action">
    用户：<input type="text" name="name" />
    密码：<input type="password" name="pwd" />
         <input type="submit" />
</form>
</body>
</html>
