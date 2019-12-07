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
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String color = req.getParameter("color");
        PrintWriter out = res.getWriter();
        List result = BeerExpert.getBrands(color);
                out.println("Beer Selection Advice\n");
        Iterator it = result.iterator();
        while(it.hasNext()) {
            out.print("\ntry: " + it.next());
        }
    }
}
