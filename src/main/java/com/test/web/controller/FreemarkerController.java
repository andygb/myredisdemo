package com.test.web.controller;

import com.test.web.dto.Person;
import com.test.web.dto.User;
import com.test.web.service.UserService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rick on 2017/4/7.
 */
@Controller
@RequestMapping(value = "person")
public class FreemarkerController {

  @Autowired
  private UserService userService;

  @RequestMapping("/list")
  public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {
    Person person = userService.getPersonByName("name");
    return new ModelAndView("index", "person", person);
  }
}
