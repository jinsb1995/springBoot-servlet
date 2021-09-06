package hello.servlet.web.servletmvc;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        // 다른 서블릿이나 JSP로 이동할 수 있는 기능이다. 서버 내부에서 다시 호출이 발생한다.
        dispatcher.forward(request, response);


        /**
         * redirect vs forward
         * 리다이렉트는 실제 클라이언트(웹 브라우저)에 나갔다가. 클라이언트가 redirect경로로 다시 요청한다.
         * 따라서 클라이언트가 인지할 수 있고, URL경로도 실제로 변경된다.
         * 반면에 포트포워드는  서버 내부에서 일어나는 호출이기 때문에 클라이언트가 전혀 인지하지 못한다.
         *
         */


    }
}
