package com.example.demo.product.controller;

import com.example.demo.product.model.dto.productReadRes;
import com.example.demo.product.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    // Service 의존성 부여
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // C
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    ResponseEntity create(productReadRes productReadRes){
        productService.create(productReadRes);
        return ResponseEntity.ok().body("생성");
    }

    // R
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    ResponseEntity list(){
        return ResponseEntity.ok().body(productService.list());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    ResponseEntity read(Integer id){
        return  ResponseEntity.ok().body(productService.read(id));
    }

    // U
//    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
//    ResponseEntity update(ProductDto productDto){
//        productService.update(productDto);
//        return ResponseEntity.ok().body("수정");
//    }
//
//    // D
//    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//    ResponseEntity delete(Integer id){
//        productService.delete(id);
//        return ResponseEntity.ok().body("삭제");
//    }


}
