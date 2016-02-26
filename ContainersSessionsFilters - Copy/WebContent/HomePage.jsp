<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="co"%>
<%@ taglib prefix="ft" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="hd" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>

</title>
</head>
<hd:Header title="Project Name"/>
<body>
<co:out value="${sessionScope.username}"/>
</body>
<ft:Footer version="current version is : 1.1.2">
</ft:Footer>


</html>