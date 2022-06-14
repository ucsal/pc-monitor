package br.ucsal.pcmonitorspring.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class EnsureAdmin implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String role = (String) request.getSession().getAttribute("role");
        if (!role.equals("ADMIN")){
            response.sendRedirect("/dashboard/home");
            return false;
        }
        return true;
    }
}
