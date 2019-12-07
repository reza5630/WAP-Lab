<%@ page import="java.util.Enumeration" %><%--
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

<%
  if(response!=null && request.getAttribute("invalidAge")!= null) {
    boolean invalidAge = (boolean) request.getAttribute("invalidAge");
    if(invalidAge)
    %>
      <p style="color: red">Invalid Age input, Age must be within this (4-100) </p>
    <%
  }
%>


<h1> The Number Quiz</h1>
<p>For each correct ans you will be scored </p>
<p>Press start when you want to start the quiz</p>
<form action="http://localhost:8080/NumberQuizJSP_war_exploded/QuizServlet">
  <input type="hidden" name="quizans" value="-1">
  <p>Please enter you age = <input type="text" name="age"></p>
  <input type="submit" value="Start"/>
</form>
</body>
</html>
