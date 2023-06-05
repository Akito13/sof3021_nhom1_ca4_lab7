package com.example.sof3021_nhom1_ca4_lab7.Service;

import com.example.sof3021_nhom1_ca4_lab7.Repository.LoaiRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Service
public class GlobalInterceptor implements HandlerInterceptor {

    @Autowired
    LoaiRepository repository;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("uri", request.getRequestURI());
        return true; }
    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res,
                           Object handler, ModelAndView mv) throws Exception {
        req.setAttribute("categories", repository.findAll());

    }

}
