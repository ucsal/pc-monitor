package br.ucsal.pcmonitorspring.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class InterceptorsMapper extends WebMvcConfigurerAdapter {
    @Autowired
    EnsureAuthentication ensureAuthentication;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(ensureAuthentication).addPathPatterns("/dashboard/*");
    }
}