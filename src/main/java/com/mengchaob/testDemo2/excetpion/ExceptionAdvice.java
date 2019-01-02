package com.mengchaob.testDemo2.excetpion;

        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.ControllerAdvice;
        import org.springframework.web.bind.annotation.ExceptionHandler;
        import org.springframework.web.servlet.ModelAndView;

/**
 * @Auther: mengchao
 * @Date: 2018-12-27 23:54
 * @Description:
 * @Version 1.0
 * @ClassName ExceptionAdvice
 */
@ControllerAdvice
public class ExceptionAdvice {//java.lang.NullPointerException.class
    //同controller中的ExceptionHandler注解一样，设定方法捕获的异常
    @ExceptionHandler(java.lang.NullPointerException.class)
    public String nullPointerException(Exception e,Model model){//这里面也可以返回视图 ModelAndView
        model.addAttribute("message",e.getMessage()+"空指针异常！");
        return "/errorinfo/exceptionAdvice";
    }

}
