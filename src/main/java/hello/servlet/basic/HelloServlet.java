package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    // 이렇게 하면 서비스 메서드가 호출된다.
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        System.out.println("들어왔다!!!! HelloServlet.service");
        System.out.println("request = " + req);
        System.out.println("response = " + res);

        String username = req.getParameter("username");
        System.out.println("username = " + username);

        res.setContentType("text/plain");
        res.setCharacterEncoding("utf-8");
        res.getWriter().write("hello " + username);

    }


}
