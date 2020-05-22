import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloServlet  extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("HelloServlet init");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("HelloServlet init config");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        //设置响应内容类型
        resp.setContentType("text/html");
        //设置逻辑实现
        PrintWriter out = resp.getWriter();
        out.println("<h3>" + "message" + "</h3>");
//        try {
//            resp.getWriter().println("<h1>Hello Servlet!</h1>");
//            resp.getWriter().println(new Date().toLocaleString());
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
    }
}
