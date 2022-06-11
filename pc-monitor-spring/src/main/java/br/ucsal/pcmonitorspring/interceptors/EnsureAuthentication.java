package br.ucsal.pcmonitorspring.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class EnsureAuthentication implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String se = (String) session.getAttribute("login");

        if (session.getAttribute("login") == null){
            System.out.println("BLOCK");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
