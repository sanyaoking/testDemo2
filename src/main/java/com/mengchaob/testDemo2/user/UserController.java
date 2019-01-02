package com.mengchaob.testDemo2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: mengchao
 * @Date: 2018-12-27 09:53
 * @Description:
 * @Version 1.0
 * @ClassName UserController
 */
@Controller
@RequestMapping(value = "userController",method = RequestMethod.POST)
public class UserController {
    private Iservice service;
    @Autowired
    public UserController(Iservice service) {
        this.service = service;
    }

    @RequestMapping(value = "showUser",method = RequestMethod.GET)
    public String showUser(User user,Model model){
        List list =  this.service.showUsers(user);
        model.addAttribute("users",list);
      return "showUsers";
    };
    /*
     * @Author mengchao
     * @Description //TODO User user这个参数必须添加否则由此跳转到addUser是会导致模板找不到属性而报错。
     * @Date 15:39 2019-1-2
     * @Param 
     * @return 
     **/
    @RequestMapping(value = "addUser",method = RequestMethod.GET)
    public String addUser(Model model,User user){
        model.addAttribute("action","/userController/saveUser");
        return "addUser";
    };

    /*
     * @Author mengchao
     * @Description //TODO bindingResult是返回的校验信息，在默认情况下必须保证User参数名称必须为类名的首字母小写的形式，
     * 如果不这样的话需要增加其他的参数配置才能使系统校验正常返回数据并提取错误信息
     * @Validated开启数据校验
     * BindingResult 绑定了校验信息,这个对象一定要紧跟在@Validated注解的参数的后面，否则系统会报异常
     * @Date 16:08 2018-12-29
     * @Param [user, model, bindingResult]
     * @return java.lang.String
     **/
    @RequestMapping(value = "saveUser")
    public String saveUser(@Validated  User user, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            System.out.println(user);
            return "addUser";
        }

        this.service.addUser(user);
        model.addAttribute("message","保存成功！");
        return "ok";
    };
}
