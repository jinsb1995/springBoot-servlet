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
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        ControllerV3 controller = (ControllerV3) handler;

        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }


//    @Override
//    public boolean supports(Object handler) {
//        // 여기에 들어온 handler가 v3랑 맞으면 true, v1~v2, v4가 들어오면 false
//        return (handler instanceof ControllerV3);
//    }
//
//    @Override
//    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
//        // 위에있는 supports가 v3라는걸 증명서 true를 반환해주면 여기 들어오게 될 건 v3이기 때문에 형변환을 해줘도 된다.
//        ControllerV3 controller = (ControllerV3) handler;
//
//        // 한 다음 여기서 뷰를 반환해야지
//        Map<String, String> paramMap = createParamMap(request);
//
//        ModelView mv = controller.process(paramMap);
//
//        return mv;
//    }
//
//    private Map<String, String> createParamMap(HttpServletRequest request) {
//        Map<String, String> paramMap = new HashMap<>();
//        request.getParameterNames().asIterator()
//                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
//        return paramMap;
//    }
}
