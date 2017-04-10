package com.test.web.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by rick on 2017/4/7.
 */
public class MyExceptionHander implements HandlerExceptionResolver {

  private static final Logger LOGGER = LoggerFactory.getLogger(MyExceptionHander.class);

  public ModelAndView resolveException(HttpServletRequest request,
      HttpServletResponse response, Object handler, Exception ex) {

    LOGGER.error("System error", ex);

    ModelAndView view = new ModelAndView("site/error");

    return view;
  }


}
