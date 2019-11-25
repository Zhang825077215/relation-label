package com.zxp.label;

import com.zxp.label.Dto.MyResponseBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class GlobalExceptionHandler {
//    public static final String DEFAULT_ERROR_VIEW = "error";
//
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        return mav;
//    }
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public MyResponseBody jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        MyResponseBody myResponseBody = new MyResponseBody();
        myResponseBody.setInfo(e.getMessage()).setCode(MyResponseBody.SYSTEMERROR);
        e.printStackTrace();
        return myResponseBody;
    }
}

