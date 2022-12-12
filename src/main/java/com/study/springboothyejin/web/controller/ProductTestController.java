package com.study.springboothyejin.web.controller;

import com.study.springboothyejin.web.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductTestController {

    @GetMapping("/product/addition")
    public String loadAddition(){
        return "product/product_add";
    }

//    @PostMapping("/api/product")
//    public String registerProduct(HttpServletRequest request){
//        System.out.println(request.getParameter("price"));
//        return "product/product_view";
//    }

//    @PostMapping("/api/product")
//    public String registerProduct(
//            @RequestParam("productCode") String pc,
//            @RequestParam("productName") String pn,
//            @RequestParam int price,
//            int stock) {
//        /*
//        변수명이 같은경우 @RequestParam 생략가능
//        하지만, 매개 변수명으로 들어올수 있는 것들이 많기 때문에 붙여주는 것이 좋음!
//        */
//
//        System.out.println("상품코드 : " + pc);
//        System.out.println("상품명 : " + pn);
//        System.out.println("가격 : " + price);
//        System.out.println("수량 : " + stock);
//        return "product/product_view";
//    }

        @PostMapping("/api/product")
        public String registerProduct(Model model, ProductDto productDto) {
            model.addAttribute("productDto", productDto);
            System.out.println(productDto);
            return "product/product_view";
        }

        @GetMapping("/product/addition2")
        public String loadAddition2(){
            return "product/product_add2";
        }

        @ResponseBody
        @PostMapping("/api/product/2")
        public String registerProduct(ProductDto productDto){
            System.out.println(productDto);
            return productDto.toString();
        }
}
