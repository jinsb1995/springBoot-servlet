package hello.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("/springmvc-/request-handler")
public class MyHttpRequestHandler implements HttpRequestHandler {

    // 핸들러 매핑은 RequestMapping 이나 BeanNameUrlMapping을 통해서 핸들러를 찾고
    // 핸들러 어댑터가 Implements를 찾아서 우리가 만든걸 찾아준다.


    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("MyHttpRequestHandler  ================== MyHttpRequestHandler.handleRequest");

    }
}
