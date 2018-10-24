package com.example.demo;

import com.example.demo.exception.MyException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;


@SpringBootApplication
@Controller
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping(path = "/err")
    public String err(){
        System.out.println("进入错误页面了=========");
        return "err";
    }

    @RequestMapping(path = {"/", "/home", "/index"})
    public String html(Model model) {
        model.addAttribute("name", "一只狐狸");
        // 当使用restController的时候会导致重定向到html失效，因为restController = ResponseBody + Controller
        return "index";
    }

    @RequestMapping(path = "/post", method = RequestMethod.POST)
    @ResponseBody
    public String testPost(HttpServletRequest req){
        String name = req.getParameter("name");
        System.out.println(req.getParameter("name"));
        return name;
    }

    @RequestMapping(path = "/test")
    public String test() throws Exception{
        throw new Exception("has a err");
    }

    @RequestMapping(path = "/testMeException")
    public String testMye() throws MyException{
        throw new MyException("302", "发生了错误，123");
    }

}


