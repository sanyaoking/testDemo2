package com.mengchaob.testDemo2.excetpion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: mengchao
 * @Date: 2018-12-29 15:08
 * @Description:
 * @Version 1.0
 * @ClassName MyHandlerExceptionResolver
 */
@Configuration
public class MyHandlerExceptionResolver  implements HandlerExceptionResolver {
    @Bean
    public MyHandlerExceptionResolver getexceptionHandler(){
        return new MyHandlerExceptionResolver();
    }
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
       ModelAndView mav = new ModelAndView();
        //通过判断不同的异常类型，跳转不同页面
        if(e instanceof java.io.IOException){
            mav.setViewName("/errorinfo/MyHandlerExceptionResolver");
            mav.addObject("info","找不到文件！");
        }
        mav.addObject("exceptioninfo",e.fillInStackTrace());
/*        Map<String, Object> model = new HashMap<String, Object>();
        model.put("appName", appName);
        return new ModelAndView("/error/jsonError", model);*/
        return mav;
    }
}
