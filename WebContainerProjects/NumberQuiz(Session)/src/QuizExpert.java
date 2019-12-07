import javax.servlet.http.HttpSession;

public class QuizExpert {
    private static String[] questions = {
            "3, 1, 4, 1, 5",
            "1, 1, 2, 3, 5",
            "1, 2, 9, 16, 25",
            "2, 3, 5, 7, 11",
            "1, 2, 4, 8, 16"
    };
    private static int[] answers = {9, 8, 36, 13, 32};

    protected static String getQuiz(int index){
        return questions[index];
    }

    protected static int getAns(int index){
        return answers[index];
    }

    protected static String makeQuizPage(HttpSession session) {
        Integer quiz = (Integer)session.getAttribute("index");
        Integer score = (Integer)session.getAttribute("score");
        Integer ans = (Integer)session.getAttribute("ans");

        if(quiz>-1 && getAns(quiz)==ans)    score++;

        System.out.println("current score "+score);
        System.out.println("next quiz "+ (++quiz));

        session.setAttribute("index", quiz);
        session.setAttribute("score", score);

        String newPage = "";
        if(quiz<5){
            newPage = "<html>\n" +
                    "<head>\n" +
                    "    <title>Number Quiz</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1> The Number Quiz</h1>\n" +
                    "<p>Your current score is "+score+" </p>\n" +
                    "<p>Guess the next number in the sequence.</p>\n" +
                    "<p>"+getQuiz(quiz)+"</p>\n" +
                    "<form action=\"http://localhost:8080/NumberQuiz_Session__war_exploded/QuizServlet\">\n" +
                    "    <p>Your answer: <input type=\"text\" name=\"quizans\"/>\n" +
                    "        <input type=\"submit\" value=\"Submit\"/>\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>";
        } else {
            newPage = "<html>\n" +
                    "<head>\n" +
                    "    <title>Number Quiz</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1> The Number Quiz</h1>\n" +
                    "<p>Your final score is "+score+" </p>\n" +
                    "</body>\n" +
                    "</html>";
            session.invalidate();
        }

        return newPage;

    }
}

