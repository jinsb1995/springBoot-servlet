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

import com.fasterxml.jackson.databind.ObjectMapper;

import hello.servlet.basic.HelloData;


@WebServlet(name = "reqBodyJsonServlet", urlPatterns = "/req-body-json")
public class RequestBodyJsonServlet extends HttpServlet{


    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletInputStream inputStream = req.getInputStream();

        String message = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("message   : " + message);


        // jsonData를 객체로 변환시켜 읽게해준다.
        HelloData helloData = objectMapper.readValue(message, HelloData.class);

        System.out.println("helloData.username : " + helloData.getUsername());
        System.out.println("helloData.age : " + helloData.getAge());



    }
}
