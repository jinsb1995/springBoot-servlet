package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {


    @Override
    public boolean support(Object handler) {
        // handler가 V3의 인스턴스냐 물어보는것임
        // MemberFormControllerV3
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        // 어댑터의 역할이 컨트롤러를 호출 해주고
        // MemberFormControllerV3
        ControllerV3 controller = (ControllerV3) handler;

        // 반환을 해주는데 반환 타입에 맞추어서 반환을 해줘야한다.
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        return mv;
    }


    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> map.put(paramName, request.getParameter(paramName)));
        return map;
    }


}
