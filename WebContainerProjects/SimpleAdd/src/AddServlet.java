import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="/AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String x = "";
        if(!req.getParameter("num1").equals("") && !req.getParameter("num2").equals("")) {
            int i = Integer.parseInt(req.getParameter("num1"));
            int j = Integer.parseInt(req.getParameter("num2"));
            x = ""+i+" + "+j+" = "+(i+j)+"\n";
            System.out.println("inside add "+x);
        }

        if(!req.getParameter("num3").equals("") && !req.getParameter("num4").equals("")) {
            int i = Integer.parseInt(req.getParameter("num3"));
            int j = Integer.parseInt(req.getParameter("num4"));
            System.out.println("inside mul "+x);
            x = x+""+i+" * "+j+" = "+(i*j);
            System.out.println("inside mul "+x);

        }

        res.getWriter().println(x);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String x = "";
        if(!req.getParameter("num5").equals("") && !req.getParameter("num6").equals("")) {

            int i = Integer.parseInt(req.getParameter("num5"));
            int j = Integer.parseInt(req.getParameter("num6"));

            x = "<html>" +
                    "<head><title>Calculator</title> </head>" +
                    "<body>"+
                    "<form action=\"AddServlet\" >"+
                    "<fieldset>" +
                    "<legend>improved calculator</legend>"+
                    "<p><input type=\"text\" name=\"num5\" value=\""+i+"\"> + <input type=\"text\" name=\"num6\" value=\""+j+"\"> = <input type=\"text\" name=\"ans1\" value=\""+(i+j)+"\"></p>";

            if(!req.getParameter("num7").equals("") && !req.getParameter("num8").equals("")) {
                i = Integer.parseInt(req.getParameter("num7"));
                j = Integer.parseInt(req.getParameter("num8"));
                x += "<p><input type=\"text\" name=\"num7\" value=\""+i+"\"> + <input type=\"text\" name=\"num8\" value=\""+j+"\"> = <input type=\"text\" name=\"ans2\" value=\""+(i*j)+"\"></p>";
            }
            else
                x += "<p><input type=\"text\" name=\"num7\"> * <input type=\"text\" name=\"num8\"> = <input type=\"text\" name=\"ans2\"></p>";

            x += "<p><input type=\"submit\"></p>"+
                    "</fieldset></form></body></html>";

            System.out.println("inside add "+x);
        }
        else {
            if(!req.getParameter("num7").equals("") && !req.getParameter("num8").equals("")) {
                int i = Integer.parseInt(req.getParameter("num7"));
                int j = Integer.parseInt(req.getParameter("num8"));

                x = "<html>" +
                        "<head><title>Calculator</title> </head>" +
                        "<body>"+
                        "<form action=\"AddServlet\" >"+
                        "<fieldset>" +
                        "<legend>improved calculator</legend>"+
                        "<p><input type=\"text\" name=\"num5\"> + <input type=\"text\" name=\"num6\"> = <input type=\"text\" name=\"ans1\"></p>" +
                        "<p><input type=\"text\" name=\"num7\" value=\""+i+"\"> + <input type=\"text\" name=\"num8\" value=\""+j+"\"> = <input type=\"text\" name=\"ans2\" value=\""+(i*j)+"\"></p>" +
                        "<p><input type=\"submit\"></p>"+
                        "</fieldset></form></body></html>";
            }
        }
       res.getWriter().println(x);
    }
}