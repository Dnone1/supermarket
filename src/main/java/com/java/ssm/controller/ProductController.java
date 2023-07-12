package com.java.ssm.controller;

import com.java.ssm.mapper.ProductMapper;
import com.java.ssm.pojo.Product;
import com.java.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService ;

    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id , Model model) {
        System.out.println(id);
        Product product = productService.getProduct(id);
        model.addAttribute("product" , product);
        return "product" ;
    }

    @RequestMapping("/productUpload")
    public String productUpload(Product product , MultipartFile fileImg , HttpServletRequest servlet , Model model) throws IOException {
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
            System.out.println(path+"-----------------");
        }



        Integer integer = productService.productUpload(product);
        return "redirect:/getListByproductId" ;
    }

    @RequestMapping("/getListByproductId")
    public String getList(Model model) {
        //默认展示所用的商品信息
        List<Product> products = productService.getList();
        model.addAttribute("products" , products);
        System.out.println(products);
        return "displayMerchant" ;
    }


    @RequestMapping("/getLisToUser")
    public String getListToUser(Model model) {
        //默认展示所用的商品信息
        List<Product> products = productService.getListToUser();
        model.addAttribute("productsToUser" , products);
        System.out.println(products);
        return "displayConsumer" ;
    }

    @RequestMapping("/delteProductByid/{id}")
    public String delteProductByid(@PathVariable Integer id) {
        productService.delteProductByid(id);
        return "redirect:/getProductByAndim" ;
    }

    @RequestMapping("/addProdect")
    public String addProdect() {
        return "Addproduct" ;
    }
    @RequestMapping("/addProdectByAndim")
    public String addProdectByAndim() {
        return "andimAddproduct" ;
    }

    @RequestMapping("/addProduct")
    public String addProduct(Product product , MultipartFile fileImg , HttpServletRequest servlet , Model model) throws IOException {
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
        return "redirect:/getListByproductId" ;
    }


}
