package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StreamUtils;

@WebServlet(name = "reqBodyStringServlet", urlPatterns = "/req-body-string")
public class RequestBodyStringServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        ServletInputStream inputStream = req.getInputStream();  // 메시지 바디의 내용을 바이트 코드로 바로 받을 수 있다.
        // 바이트를 String으로 바꿔줘야함
        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + message);

        res.getWriter().write("ok");

    }

}