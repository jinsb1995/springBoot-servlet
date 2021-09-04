package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 파라미터 전송 기능
 * http://localhost:8080/req-param?username=hello&age=20
 */
@WebServlet(name = "reqParamServlet", urlPatterns = "/req-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[전체 파라미터 조회] - start");

        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " = " + req.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();


        System.out.println("[단일 파라미터 조회] - start");
        String username = req.getParameter("username");
        String age = req.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회] - start");
        // 하나의 키에 여러가지 value가 있으면 이렇게 뽑아오면 된다.
        String[] usernames = req.getParameterValues("username");
        for(String name : usernames) {
            System.out.println(name);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - end");
        System.out.println();

        resp.getWriter().write("ok");

        // 복수 파라미터에서 단일 파라미터 조회f
        /*
         * req.getParameter()는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을때 사용해야한다.
         * 지금처럼 중복일때는 req.getParameterValues() 를 사용
         *
         */
    }

}