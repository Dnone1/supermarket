package com.java.ssm.controller;

import com.java.ssm.pojo.Order;
import com.java.ssm.pojo.Product;
import com.java.ssm.pojo.Shopping;
import com.java.ssm.pojo.User;
import com.java.ssm.service.OrderService;
import com.java.ssm.service.ProductService;
import com.java.ssm.service.ShoppingService;
import com.java.ssm.service.UserService;

import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService ;

    @Autowired
    private ShoppingService shoppingService ;

    @Autowired
    private ProductService productService ;
    
    @Autowired
    private UserService userService ;

    @RequestMapping("/orderList")
    public String orderList(HttpSession session , Model model){
        User user = (User)session.getAttribute("administratorUser");
        List<Order> orderList = orderService.orderList(user.getId());
        System.out.println(orderList);
        model.addAttribute("orders" , orderList);
        return "displayConsumer_order" ;
    }

    @RequestMapping("/addOrderByshoppingId/{shoppingId}")
    public String addOrderByShoppingId(@PathVariable Integer shoppingId , Model model) {
        Shopping shopping = shoppingService.addOrderByShoppingId(shoppingId);
        System.out.println(shopping);
        model.addAttribute("addOrder" , shopping );
        return "order" ;
    }

    @RequestMapping("/addOrdersBy")
    public String addOrder(Order order , Integer shoppingId) {
        /*
        我们需要执行两条sql语句
        一条下单，一条删除购物车
         */
        System.out.println(shoppingId);
        System.out.println("----------------------");
        System.out.println(order);
        orderService.addOrder(order);
        shoppingService.removeShopping(shoppingId);
        return "redirect:/orderList" ;
    }


    @RequestMapping("/OrderByMerchant")
    public String orderList(Model model) {
        List<Order> orders = orderService.ordersByMerchant();
        System.out.println(orders);
        model.addAttribute("orderList" , orders);
        return "displayMerchant_Order" ;
    }

    @RequestMapping("/removeOrder/{id}")
    public String removeOrder(@PathVariable Integer id) {
        orderService.removeOrder(id);
        return "redirect:/OrderByMerchant" ;
    }

    @RequestMapping("/removeOrderByConsumer/{id}")
    public String removeOrderByConsumer(@PathVariable Integer id) {
        orderService.removeOrder(id);
        return "redirect:/orderList" ;
    }

    @RequestMapping("/orderMerchant/{id}")
    public String uploadOrderByMerchantId(@PathVariable  Integer id , Model model) {
        Order order = orderService.uploadOrderByMerchantId(id) ;
        System.out.println(order);
        model.addAttribute("orderOne" , order );
        return "uploadOrderConsumer" ;
    }

    @RequestMapping("/uploadOrder/{id}")
    public String uploadOrder(@PathVariable  Integer id , Model model) {
        Order order = orderService.uploadOrderByMerchantId(id) ;
        System.out.println(order);
        model.addAttribute("orderOne" , order );
        return "andim_updateOrder" ;
    }



    @RequestMapping("/addOrderByProductIdToNew/{id}")
    public String addOrderByProductIdToNew(@PathVariable Integer id , Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product" , product );
        return "purchase" ;
    }

    @RequestMapping("/uploadOrder")
    public String uploadOrder(Order order) {
        orderService.uploadOrderById(order) ;

        return "redirect:/orderList" ;
    }

    @RequestMapping("/uploadOrderByMerchant")
    public String uploadOrderByMerchant(Order order) {
        orderService.uploadOrderById(order) ;

        return "redirect:/OrderByMerchant" ;
    }
    

    @RequestMapping("/uploadOrderByAndim")
    public String uploadOrderByAndim(Order order) {
        orderService.uploadOrderById(order) ;
        return "redirect:/orderListByAndim" ;
    }

    @RequestMapping("/animals")
    public String addOrderByIn(@RequestParam("selected") String selectedValues ) {
        System.out.println(selectedValues);
        String[] split = selectedValues.split(",");
        for(String s : split) {
            System.out.println(s);
        }
        List<Shopping> list = shoppingService.getShoppingByArr(split);
        list.forEach(System.out::println);
        
        
        
        List<Order> orderList = new ArrayList<>();
        for(Shopping s : list) {
        	User user = userService.getUserByid(s.getUser().getId());
            Order order = new Order() ;
            order.setUserId(s.getUser().getId());
            order.setProductId(s.getProductId());
            order.setQuantity(s.getQuantity());
            order.setPrice(s.getPrice());
            order.setAddress(user.getAddress());
            order.setStatus(s.getId());
            System.out.println(order);
            orderList.add(order);
        }
        orderList.forEach(System.out::println);
        System.out.println();
        for(Order o : orderList) {
            orderService.addOrder(o);
            shoppingService.removeShopping(o.getStatus()) ;
        }
        return "redirect:/orderList" ;
    }


}
