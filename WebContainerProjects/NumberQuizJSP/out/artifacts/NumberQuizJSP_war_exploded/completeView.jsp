<%--
  Created by IntelliJ IDEA.
  User: reza5630
  Date: 12/3/2019
  Time: 10:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <title>Quiz Finished</title>
</head>
<body>
<p>your age is <%=request.getParameter("age")%></p>
<%
    Integer score = (Integer)session.getAttribute("score");
    Integer correctAns = (Integer)session.getAttribute("correctans");
    boolean wrongAns = (boolean) session.getAttribute("wrongans");
    session.invalidate();

    String grade = "";
    if(score>44)
        grade = "A";
    else if(score>34)
        grade = "B";
    else if(score>24)
        grade = "C";
    else
        grade = "N";
%>


<%
    if (wrongAns) {
%>
<p>Sorry correct ans was <%=correctAns %></p>
<%
    }
%>

<h1>Thanks for participating Number Quiz</h1>
<p>Your final score is <%=score%> </p>

<p>Your final grade is <span style="color: red"><%=grade%></span></p>
</body>
</html>
