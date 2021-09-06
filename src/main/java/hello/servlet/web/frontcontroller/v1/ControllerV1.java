package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {

    // 서블릿과 비슷한 모양의 컨트롤러 인터페이스를 도입한다.
    // 각 컨트롤러들은 이 인터페이스를 implements하면 된다.
    // 프론트 컨트롤러는 이 인터페이스를 호출해서 구현과 관계없이 로직의 일관성을 가져갈 수 있다.
    // 이제 이 인터페이스를 구현한 컨트롤러를 만들자. 지금은 기존 로깆ㄱ을 최대한 유지하는게 핵심이다.
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}