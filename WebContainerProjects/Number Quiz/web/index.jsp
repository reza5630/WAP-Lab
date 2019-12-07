<%--
  Created by IntelliJ IDEA.
  User: reza5630
  Date: 12/2/2019
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number Quiz</title>
</head>
<body>
<h1> The Number Quiz</h1>
<p>Your current score is 0 </p>
<p>Guess the next number in the sequence.</p>
<p>3, 1, 4, 1, 5</p>
<form action="${pageContext.request.contextPath}/QuizServlet">
    <input type="hidden" name="currentQuiz" value=0 />
    <input type="hidden" name="currentScore" value=0 />
    <p>Your answer: <input type="text" name="quizAns"/>
        <input type="submit" value="Submit"/>
</form>
</body>
</html>
