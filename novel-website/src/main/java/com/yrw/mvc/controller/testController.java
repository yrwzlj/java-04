package com.yrw.mvc.controller;

import com.yrw.mvc.bean.Book;
import com.yrw.mvc.bean.User;
import com.yrw.mvc.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static com.yrw.mvc.service.UserService.UserSearchByUsername;
import static com.yrw.mvc.service.UserService.addUser;

@Controller
public class testController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/signinUser")
    public String sighin(User user){
        System.out.println(user);
        if (UserSearchByUsername(user))
            return "success";
        else
            return "fail";
    }

    @RequestMapping("/signupUser")
    public String sighup(User user){
        System.out.println(user);
        addUser(user);
        return "success";
    }

    @RequestMapping("/website")
    public String success(){
        return "book";
    }

    @RequestMapping(value = "/BookSearchById", method = RequestMethod.POST)
    public String BookSearchByIdcontroller(Model model,String name){
        Book book = BookService.BookSearchById(name);
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        //向请求域共享数据
        System.out.println(book);
        if (book.getName() == null)
        {
            return "searchfail";
        }
        else{
            model.addAttribute("Book", book);
            return "bookNameResult";
        }
    }

    @RequestMapping(value = "/BookSearchByAuthor", method = RequestMethod.POST)
    public String BookSearchByAuthorcontroller(Model model,String author){
        List<Book> list = BookService.BookSearchByAuthor(author);
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        //向请求域共享数据
        System.out.println(list);
        if (list.isEmpty())
        {
            return "searchfail";
        }
        else{
            model.addAttribute("BookList", list);
            return "bookcontent";
        }
    }


}
