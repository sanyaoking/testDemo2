package com.mengchaob.testDemo2.excetpion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * @Auther: mengchao
 * @Date: 2018-12-29 14:31
 * @Description:
 * @Version 1.0
 * @ClassName ExceptionConfig
 */
@Configuration
public class ExceptionConfig {
    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver smer = new SimpleMappingExceptionResolver();
        Properties p = new Properties();
        //可以配置多个异常捕捉，但是需要注意，p中的key必须是异常的全路径
        p.put("java.lang.ArrayIndexOutOfBoundsException","/errorinfo/exceptionConfig");
        smer.setExceptionMappings(p);
        //页面可以通过${exception}获取信息
        return smer;
    }
}
