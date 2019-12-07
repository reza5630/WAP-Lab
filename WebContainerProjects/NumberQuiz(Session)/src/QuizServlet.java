import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="/QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        HttpSession session =  req.getSession();
        if(session.getAttribute("index") == null || session.getAttribute("index") == ""){
            session.setAttribute("index", -1);
            session.setAttribute("score", 0);
            session.setAttribute("ans", 0);
        } else
            session.setAttribute("ans", Integer.parseInt(req.getParameter("quizans")));
        res.getWriter().println(QuizExpert.makeQuizPage(session));
    }
}
