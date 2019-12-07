import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="/QuizServlet", urlPatterns = {"/QuizServlet"})
public class QuizServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        try {
            int age = Integer.parseInt(req.getParameter("age"));
            if(age<4 || age>100)
                throw new Exception();
        }catch (Exception e) {
            System.out.println("age exception thrown");
            req.setAttribute("invalidAge", true);
            RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.forward(req,res);
        }

        HttpSession session =  req.getSession();
        if(session.getAttribute("index") == null || session.getAttribute("index") == ""){
            session.setAttribute("index", 0);
            session.setAttribute("score", 0);
            session.setAttribute("attempt", 0);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/quizView.jsp");
        rd.forward(req,res);
    }
}
