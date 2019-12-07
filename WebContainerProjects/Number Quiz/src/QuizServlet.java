import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="/QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Enumeration<String> params = req.getParameterNames();
        int quiz = Integer.parseInt(req.getParameter(params.nextElement()));
        int score = Integer.parseInt(req.getParameter(params.nextElement()));
        int ans = Integer.parseInt(req.getParameter(params.nextElement()));

        if(QuizExpert.getAns(quiz)==ans)    score++;

        System.out.println("current score "+score);
        System.out.println("next quiz "+ (++quiz));

        if(quiz<5){
            String newPage = "<html>\n" +
                    "<head>\n" +
                    "    <title>Number Quiz</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1> The Number Quiz</h1>\n" +
                    "<p>Your current score is "+score+" </p>\n" +
                    "<p>Guess the next number in the sequence.</p>\n" +
                    "<p>"+QuizExpert.getQuiz(quiz)+"</p>\n" +
                    "<form action=\"http://localhost:8080/Number_Quiz_war_exploded/QuizServlet\">\n" +
                    "    <input type=\"hidden\" name=\"currentQuiz\" value="+quiz+" />\n" +
                    "    <input type=\"hidden\" name=\"currentScore\" value="+score+" />\n" +
                    "    <p>Your answer: <input type=\"text\" name=\"quizans\"/>\n" +
                    "        <input type=\"submit\" value=\"Submit\"/>\n" +
                    "</form>\n" +
                    "</body>\n" +
                    "</html>";
            res.getWriter().println(newPage);
        }
        else {
            String newPage = "<html>\n" +
                    "<head>\n" +
                    "    <title>Number Quiz</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<h1> The Number Quiz</h1>\n" +
                    "<p>Your final score is "+score+" </p>\n" +
                    "</body>\n" +
                    "</html>";
            res.getWriter().println(newPage);
        }

    }
}