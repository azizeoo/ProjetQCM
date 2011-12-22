<%@ page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>QCM Projet</title>
</head>
<body>
	<h2>QCM Projet</h2>

	<form name="valider" method="POST" action="correction.html">
		<c:forEach items="${questionnaire.subscribers}" var="subscriber">
			<li>Bonjour : <c:out value="${subscriber.firstName}" /> <input
				type="hidden" name="iduserreponse"
				value="${subscriber.idSubscriber}">
			</li>
			<hr />
		</c:forEach>
		<ul>

			<c:forEach items="${questionnaire.topic.lesQuestions}" var="question">
				<li><input type="hidden" name="questionss"
					value="${question.libelle}"> <strong><c:out
							value="${question.libelle}" /></strong></li>
				<c:forEach items="${question.lesReponses}" var="reponse">

					<input type="checkbox" name="response" value="${reponse.libelle}">
					<c:out value="${reponse.libelle}" />
					<br>
				</c:forEach>
				<hr />
			</c:forEach>
		</ul>
		<hr />
		<input type="submit" />
	</form>
</html>