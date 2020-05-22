import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        printRequest(req);

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        System.out.println("name:" + name);
        System.out.println("password:" + password);
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().println("name:"+name);
//        resp.getWriter().println("password:"+password);
        if ("adm".equals(name) && "123".equals(password)) {
            req.getRequestDispatcher("login_success.html").forward(req, resp);
        } else {
            resp.sendRedirect("login_failure.html");
        }
    }

    private void printRequest(HttpServletRequest request) {
        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());
    }
}
