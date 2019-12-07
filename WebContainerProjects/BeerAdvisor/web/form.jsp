<%--
  Created by IntelliJ IDEA.
  User: reza5630
  Date: 12/1/2019
  Time: 2:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Beer Advisor</title>
</head>
<body>
<h1> Beer Selection Page</h1>
<form action="${pageContext.request.contextPath}/BeerSelect">
  <p>Color: <select name="color">
    <option value="light">light</option>
    <option value="amber">amber</option>
    <option value="brown">brown</option>
    <option value="dark">dark</option>
  </select></p>
  <input type="submit" value="Submit"/>
</form>
<p>Select beer characteristics</p>
</body>
</html>
