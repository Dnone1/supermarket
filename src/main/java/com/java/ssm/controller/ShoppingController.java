package com.java.ssm.controller;

import com.java.ssm.pojo.Product;
import com.java.ssm.pojo.Shopping;
import com.java.ssm.pojo.User;
import com.java.ssm.service.ProductService;
import com.java.ssm.service.ShoppingService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShoppingController {


    @Autowired
    private ShoppingService shoppingService;

    @Autowired
    private ProductService productService ;



    @RequestMapping("/likeProdect")
    public String likeProduct(String name ,Model model) {
    	List<Product> product = productService.likeProduct(name);
    	if(product != null && product.size() >= 1) {
    		model.addAttribute("like" , product) ;
    		System.out.println(product);
        	return "likeProduct" ;
    	}
    	return "404";
    	
    }

    @RequestMapping("/addShoppingByUserid/{userId}/{productId}/{productPrice}")
    public String addShoppingByUserId(@PathVariable Integer userId , @PathVariable Integer productId , @PathVariable double productPrice) {
         /*
        当加入购物车之后，先进行判断，是否存在购物车，如果存在就让购物车数量加+1 ， 如果不存在就创建
         */
        Shopping shopping = shoppingService.IFShopping(userId , productId) ;
        System.out.println(shopping);

        System.out.println(productPrice);
        if(shopping != null){
           shoppingService.shoppingProduct(shopping.getId() , productPrice) ;
        }else {
            shoppingService.addShoppingByUserId(userId , productId  , productPrice);
        }

        productService.removeById(productId) ;
        return "redirect:/getLisToUser" ;
    }

    @RequestMapping("/removeShopping/{shoppingId}/{productQuantity}/{productId}")
    public String removeShopping(@PathVariable Integer shoppingId , @PathVariable Integer productQuantity ,@PathVariable Integer productId) {
        /*
        当我点击删除，会执行两条sql，一条删除购物城，一条根据商品id，进行库存增加
         */
        Integer integer = shoppingService.removeShopping(shoppingId);
        if(integer >= 1) {
            System.out.println("购物车删除成功");
            productService.addProductByShopping(productId , productQuantity);
        }
        return "redirect:/getShoppingList" ;
    }

    @RequestMapping("/getShoppingList")
    public String getShoppingList(Model model , HttpSession session) {
        User user =(User) session.getAttribute("administratorUser");
        List<User> shoppingList = shoppingService.getShoppingList(user.getId());
        model.addAttribute("shoppingList" , shoppingList );
        System.out.println(shoppingList);
        return "displayConsumer_Shopping" ;
    }



}
