<%--@elvariable id="question" type="com.ilyoniss.module3final.gameobjects.Question"--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>UFO GAME</title>
</head>

<h1>UFO GAME</h1>
<h2>${question.questionText}</h2>

<form action="TextGameServlet" method="post">
    <c:forEach var="answer" items="${question.answers}" varStatus="status">
        <input type="radio" name="userChoice" value="${status.index}" id="answer${status.index}" />
        <label for="answer${status.index}">${answer.answerText}</label><br>
    </c:forEach>
    <input type="submit" value="ответить">
</form>

</body>
</html>
