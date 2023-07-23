<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>UFO GAME</title>
</head>
<body>
<h1>UFO GAME</h1>
<form action="TextGameServlet" method="post">
    <c:forEach var="answer" items="${question.answers}" varStatus="status">
        <input type="radio" name="userChoice" value="${status.index}" id="answer${status.index}" />
        <label for="answer${status.index}">${answer.answerText}</label><br>
    </c:forEach>
    <input type="submit" value="ответить">
</form>
<p>${question.questionText}</p>
<p>${message}</p>
</body>
</html>
