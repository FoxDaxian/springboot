package com.example.demo.exception;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.WebDataBinder;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    public final String DEFAULT_ERROR_VIEW = "err";

    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    // 全局捕获异常函数
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", e.getMessage());
        return map;

    }

    // 捕获自定义异常
    @ExceptionHandler(value = MyException.class)
    public ModelAndView myErrHandler(MyException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        modelAndView.addObject("code", e.getCode());
        modelAndView.addObject("msg", e.getMsg());
        System.out.println(modelAndView);
        return modelAndView;
    }
}
