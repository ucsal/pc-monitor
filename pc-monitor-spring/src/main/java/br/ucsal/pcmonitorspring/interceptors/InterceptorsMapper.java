package br.ucsal.pcmonitorspring.interceptors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsMapper implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new EnsureAuthentication()).addPathPatterns("/dashboard/*");
        registry.addInterceptor(new EnsureAdmin()).addPathPatterns("/cadastro");
    }
}