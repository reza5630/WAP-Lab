import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

@WebServlet(name="/BeerSelect", urlPatterns = {"/BeerSelect"})
public class BeerSelect extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String color = req.getParameter("color");
        List result = BeerExpert.getBrands(color);
        req.setAttribute("result", result);
        RequestDispatcher rd = req.getRequestDispatcher("searchResults.jsp");
        rd.forward(req,res);
    }
}
