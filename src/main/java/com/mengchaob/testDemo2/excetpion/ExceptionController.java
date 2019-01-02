package com.mengchaob.testDemo2.excetpion;

import com.mengchaob.testDemo2.user.Iservice;
import com.mengchaob.testDemo2.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;
import java.util.List;

/**
 * @Auther: mengchao
 * @Date: 2018-12-27 09:53
 * @Description:
 * @Version 1.0
 * @ClassName UserController
 */
@Controller
@RequestMapping(value = "exceptionController",method = RequestMethod.POST)
public class ExceptionController {
    /*
     * @Author mengchao
     * @Description //TODO 抛出下标越界异常
     * @Date 23:50 2018-12-27
     * @Param
     * @return
     **/
    @RequestMapping(value = "showIndexException",method = RequestMethod.GET)
    public String showIndexException(User user,Model model){
        String[] str = new String[5];
        str[6]="";
        return "showUsers";
    };
    /*
     * @Author mengchao
     * @Description //TODO 文件找不到的异常
     * @Date 23:50 2018-12-27
     * @Param
     * @return
     **/
    @RequestMapping(value = "showNotFindFileException",method = RequestMethod.GET)
    public String showNotFindFileException(User user,Model model) throws IOException {
       File f = new File("d://app.jsp");
        InputStream is = new FileInputStream(f);
        byte[] b = new byte[1024];
        is.read(b);
        return "showUsers";
    };
    /*
     * @Author mengchao
     * @Description //TODO 抛出空指针异常
     * @Date 23:50 2018-12-27
     * @Param 
     * @return 
     **/
    @RequestMapping(value = "showNullException",method = RequestMethod.GET)
    public String showNullException(User user,Model model){
        String str = null;
        str.trim();
      return "showUsers";
    };
    /*
     * @Author mengchao
     * @Description //TODO 抛出分母不能为0的异常
     * @Date 23:50 2018-12-27
     * @Param 
     * @return 
     **/
    @RequestMapping(value = "showZeroException",method = RequestMethod.GET)
    public String showZeroException(Model model){
        int i=1/0;
        return "addUser";
    };
    @RequestMapping(value = "defaultException",method = RequestMethod.GET)
    public String showdefaultException(Model model){
        int i=1/0;
        return "addUser";
    };
    /*
     * @Author mengchao
     * @Description //TODO
     * 此ExceptionHandler注解,捕获了ArithmeticException，这个ExceptionController所抛出的捕获了ArithmeticException异常都会被这个方法捕捉，跳转到对应页面
     * 如果想要捕捉别的异常，那么可以在注解中可以放多个异常class@ExceptionHandler({ArithmeticException.class,java.lang.NullPointerException.class})
     * 如果需要对不同的异常做不通的处理，可以在捕捉异常的方法中做异常类型判断；也可以在创建一个@ExceptionHandler。
     * @Date 23:42 2018-12-27
     * @Param
     * @return
     **/
    @ExceptionHandler({ArithmeticException.class})
    public String exceptionNameHanddler(Exception exception,Model model){
        //方法里面处理异常信息，并返回到视图解析器
        model.addAttribute("message",exception.getMessage());
        return "/errorinfo/exceptionHandler";
    }

}
