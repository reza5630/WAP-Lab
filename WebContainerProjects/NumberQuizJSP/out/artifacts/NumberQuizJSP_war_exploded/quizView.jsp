<%--
  Created by IntelliJ IDEA.
  User: reza5630
  Date: 12/3/2019
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="javax.servlet.http.HttpSession" %>
<html>
<head>
    <title>Number Quiz</title>
</head>
<body>

<%!
    private static String[] questions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 2, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };
    private static int[] answers = {9, 8, 36, 13, 32};

    protected static String getQuiz(int index) {
        return questions[index];
    }

    protected static int getAns(int index) {
        return answers[index];
    }

    private boolean wrongans = false;
%>


<%
    Integer index = (Integer) session.getAttribute("index");
    Integer score = (Integer) session.getAttribute("score");
    Integer attempt = (Integer) session.getAttribute("attempt");
    Integer ans = Integer.parseInt(request.getParameter("quizans"));
    String age = request.getParameter("age");


    if (getAns(index) == ans) {
        if (attempt == 3) score += 2;
        else score += 10 / attempt;
        System.out.println("passed");
        wrongans =false;

        System.out.println("current score " + score);
        System.out.println("next quiz " + (++index));

        session.setAttribute("attempt", 1);     attempt =1;
        session.setAttribute("index", index);
        session.setAttribute("score", score);

    } else if (attempt < 3) {
        System.out.println("attempt.. " + (++attempt));
        session.setAttribute("attempt", attempt);

    } else {
        System.out.println("failed");
        wrongans = true;
        System.out.println("current score " + score);
        System.out.println("next quiz " + (++index));

        session.setAttribute("attempt", 1);     attempt =1;
        session.setAttribute("index", index);
        session.setAttribute("score", score);
    }

    if (index==questions.length) {
        RequestDispatcher rd = request.getRequestDispatcher("/completeView.jsp");
        session.setAttribute("wrongans", wrongans);
        session.setAttribute("correctans", getAns(index-1));
        rd.forward(request,response);
    }
%>



<h1> The Number Quiz</h1><p>your age is <%=age%></p>

<%
    if (wrongans) {
%>
<p>Sorry correct ans was <%=getAns(index - 1) %></p>
<%
    }
%>


<p>Your current score is <%=score%></p>


<%
    if (attempt>1) {
%>
<p>try again... (attempt = <%=attempt %>)</p>
<%
    }
%>
<p>Guess the next number in the sequence.</p>
<p><%=getQuiz(index)%>
</p>
<form action="http://localhost:8080/NumberQuizJSP_war_exploded/QuizServlet">
    <p>Your answer: <input type="text" name="quizans"/>
        <input type="submit" value="Submit"/>
    <input type="hidden" name="age" value=<%=age%>>
</form>
</body>
</html>
