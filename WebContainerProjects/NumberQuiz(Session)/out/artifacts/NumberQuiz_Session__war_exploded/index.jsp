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
<p>For each question you will be scored 1 points </p>
<p>Press start when you want to start the quiz</p>
<form action="http://localhost:8080/NumberQuiz_Session__war_exploded/QuizServlet">
    <input type="submit" value="Start"/>
</form>
</body>
</html>
