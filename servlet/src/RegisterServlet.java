import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println("service 获取单值参数 name:" + name);
        String[] hobits = req.getParameterValues("hobits");
        if (null != hobits)
            System.out.println("service 获取具有多值的参数 hobits:" + Arrays.asList(hobits));
        Map<String, String[]> map = req.getParameterMap();
        System.out.println("通过 getParameterMap 遍历所有的参数");
        if (null != map)
            for (Map.Entry<String, String[]> entry : map.entrySet()
            ) {
                System.out.println(entry.getKey() + ":" + Arrays.asList(entry.getValue()));
            }
    }
}
