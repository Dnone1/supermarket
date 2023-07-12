package com.java.ssm.controller;

import com.java.ssm.mapper.AdministratorMapper;
import com.java.ssm.pojo.Administrator;
import com.java.ssm.pojo.Product;
import com.java.ssm.pojo.User;
import com.java.ssm.service.AdministratorService;
import com.java.ssm.service.OrderService;
import com.java.ssm.service.ProductService;
import com.java.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService ;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private ProductService productService ;

    @RequestMapping(value = "/user/login" , method = RequestMethod.POST)
    private String userLogin(String username , String password , HttpSession session , Model model) {
        User user = userService.userLogin(username, password);
        System.out.println("username"+username);
        System.out.println("password"+password);
        System.out.println(user);
        //当查询到的user为null的时候，说明用户不存在
        if(user != null) {
            //等于0是消费者
            if(user.getIsSeller() == 0) {
                System.out.println("消费者");
                session.setAttribute("administratorUser" , user);
                return "redirect:/getLisToUser" ;
            }else {
                System.out.println("商家");
                session.setAttribute("administratorUser" , user);
                List<Product> products = productService.getList();
                model.addAttribute("products" , products);
                System.out.println(products);
                return "displayMerchant" ;
            }

        //当查到user为null的时候，说明有两种情况
        //1 账号或者密码错误
        //2 为管理员
        }else {
            Administrator administrator = administratorService.adminLogin(username, password);
            if(administrator != null) {
                System.out.println("管理员");
                session.setAttribute("administratorUser" , administrator);
                System.out.println(administrator);
                return "redirect:/getProductByAndim" ;
            }else {
                System.out.println("账号或者密码错误");
                return "index" ;
            }
        }

    }

    @RequestMapping("/userUpload/{id}")
    public String userUpload(@PathVariable("id") Integer id , Model model) {
        User user = userService.uploadUser(id);
        System.out.println(id);
        System.out.println(user);
        model.addAttribute("user" , user);
        return "uploadUser";
    }

    @RequestMapping("/administrator/userUpload")
    public String administratorUserUpload(User user) {
        System.out.println("user"+user);
        
        userService.administratorUserUpload(user);
        return "index" ;
    }

    @RequestMapping("/insertUser")
    public String insertUser(User user) {
        System.out.println(user);
        User boo = userService.getUserByName(user.getUsername()) ;
        if(boo == null) {
            userService.insertUser(user);
            return "index" ;
        }
        return "insertErro";

    }

    @RequestMapping("/deleteUserByAndim/{id}")
    public String deleteUserByAndim(@PathVariable Integer id) {
        Integer i = userService.deleteUser(id);
        return "redirect:/oderByUsers" ;
    }



}
