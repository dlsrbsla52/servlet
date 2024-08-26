package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
*
*/
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("request param servlet");
        System.out.println("[전체 파라미터 조회] - Start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramname -> System.out.println(paramname + "=" + request.getParameter(paramname)));

        System.out.println("[전체 파라미터 조회] - End");
        System.out.println();

        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("username =" + username);
        String age = request.getParameter("age");
        System.out.println("age =" + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] useranems = request.getParameterValues("username");

        for (String name : useranems) {
            System.out.println("username = "+name);
        }

        response.getWriter().println("Ok");
        request.getParameterNames();
    }
}
