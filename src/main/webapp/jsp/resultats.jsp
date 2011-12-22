<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Merci</title>
</head>
<body>
	Merci pour participation Mr/Mlle:
	<strong><c:out value="${subscriberDB.firstName}" />, <c:out
			value="${subscriberDB.lastName}" /></strong>
</body>
</html>