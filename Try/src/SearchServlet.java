import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name="/SearchServlet", urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchString = req.getParameter("searchString");
        System.out.println("Search string is  : ==== >" + searchString);
        String searchQuery = "select * from entries where word = \'" + searchString + "\'";
        Connection connection = DbConnection.getConnection();

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(searchQuery);
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.print("<table class=\'table\'>");

            while (rs.next()) {

                String x = "<tr>"
                        + "<td class=\'word\'>" + rs.getString(1) + " </td> "
                        + "<td class=\'word-type\'>" + rs.getString(2) + " </td> "
                        + "<td class=\'definition\'> " + rs.getString(3) + " </td> "
                        + "</tr>";
                System.out.println(x);
                out.print(x);
            }
            out.print("</table>");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
