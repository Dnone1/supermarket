package com.java.ssm.controller;

import com.java.ssm.mapper.AdministratorMapper;
import com.java.ssm.pojo.Administrator;
import com.java.ssm.pojo.Order;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

//    @RequestMapping("/administrator/userUpload")
//    public String uploadUser() {
//
//    }


    @RequestMapping("/getProductByAndim")
    public String getList(Model model , HttpSession session) {
        //默认展示所用的商品信息
        List<Product> products = productService.getList();
        model.addAttribute("productss", products);
		/*
		 * Administrator user =
		 * (Administrator)session.getAttribute("administratorUser");
		 * session.setAttribute("administratorUser1" , user);
		 */
        System.out.println("products"+products);
        return "andim_shopping";
    }

    @RequestMapping("/orderListByAndim")
    public String orderList(Model model) {
        List<Order> orders = orderService.ordersByMerchant();
        System.out.println(orders);
        model.addAttribute("orderLists", orders);
        return "andim_order";
    }

    @RequestMapping("/oderByUsers")
    public String userList(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "andim_users";
    }

    @RequestMapping("/removeOrderByAndim/{id}")
    public String removeOrder(@PathVariable Integer id) {
        orderService.removeOrder(id);
        return "redirect:/orderListByAndim";
    }

    @RequestMapping("/productByAndim/{id}")
    public String getProduct(@PathVariable Integer id, Model model) {
        System.out.println(id);
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);
        return "andim_product";
    }

    @RequestMapping("/uploadUserByAndim/{id}")
    public String uploadUserByAndim(@PathVariable Integer id , Model model) {
        User user = userService.uploadUser(id);
        System.out.println(id);
        System.out.println(user);
        model.addAttribute("users", user);
        return "andim_uploadUser";

    }

    @RequestMapping("/administratorByUpload")
    public String administratorUserUpload(User user) {
        System.out.println("user"+user);
        userService.administratorUserUpload(user);
        return "redirect:/oderByUsers" ;
    }

    @RequestMapping("/proByAndim")
    public String productUpload(Product product , MultipartFile fileImg , HttpServletRequest servlet , Model model) throws IOException {
        System.out.println(product);
        System.out.println(product);
        //获取当前项目的上下文路径
        ServletContext servletContext = servlet.getSession().getServletContext();
        //获取upload文件夹是否存在在当前路径
        String path = servletContext.getRealPath("upload");
        System.out.println("servletContext "+servletContext);
        System.out.println("path "+path);

        File file = new File(path);
        if(!file.exists()) {
            file.mkdir();
        }

        //获取文件的名称
        String originalFilename = fileImg.getOriginalFilename();
        System.out.println("originalFilename"+originalFilename);
        
        if(originalFilename != null && originalFilename.trim() != "") {
            //前缀拼接uuid
            String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFile = UUID.randomUUID().toString()+substring;
            System.out.println(newFile);
            //上传文件
            fileImg.transferTo(new File(file , newFile));

            //获取文件：http://localhost:9282/文件夹/文件
            String uploadNewFile = servlet.getScheme()+"://"+servlet.getServerName()+":"+servlet.getServerPort()+"/upload/"+newFile ;
            System.out.println(uploadNewFile);
            //filename.transferTo(new File());
            product.setPath(uploadNewFile);
        }



        Integer integer = productService.productUpload(product);

        return "redirect:/getProductByAndim" ;
    }

    @RequestMapping("/addProductByAndim")
    public String addProductByAndim(Product product , MultipartFile fileImg , HttpServletRequest servlet , Model model) throws IOException {
        System.out.println(product);
        //获取当前项目的上下文路径
        ServletContext servletContext = servlet.getSession().getServletContext();
        //获取upload文件夹是否存在在当前路径
        String path = servletContext.getRealPath("upload");
        System.out.println("servletContext "+servletContext);
        System.out.println("path "+path);

        File file = new File(path);
        if(!file.exists()) {
            file.mkdir();
        }

        //获取文件的名称
        String originalFilename = fileImg.getOriginalFilename();
        System.out.println("originalFilename"+originalFilename);
        //前缀拼接uuid
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFile = UUID.randomUUID().toString()+substring;
        System.out.println(newFile);


        //上传文件
        fileImg.transferTo(new File(file , newFile));

        //获取文件：http://localhost:9282/文件夹/文件
        String uploadNewFile = servlet.getScheme()+"://"+servlet.getServerName()+":"+servlet.getServerPort()+"/upload/"+newFile ;
        System.out.println(uploadNewFile);
        //filename.transferTo(new File());
        product.setPath(uploadNewFile);
        System.out.println(path+"-----------------");
        product.setPath(uploadNewFile);
        Integer integer = productService.addProduct(product) ;
        return "redirect:/getProductByAndim" ;
    }

}
