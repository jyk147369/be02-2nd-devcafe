package com.example.demo.product.service;

import com.example.demo.product.model.Product;
import com.example.demo.product.model.dto.productReadRes;
import com.example.demo.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    // 레포지토리 의존성 부여
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 서비스 제공
    // CRUD

    // Create
    // 상품 생성
    public void create(productReadRes productReadRes) {
        productRepository.save(Product.builder()
                .id(productReadRes.getId())
                .price(productReadRes.getPrice())
                .name(productReadRes.getName())
                .build());
    }

    // Read
    // 상품 조회
    // 전체 조회
    public List<Product> list() {
        return productRepository.findAll();
    }

    // 부분 조회
    public productReadRes read(Integer id) {
        Optional<Product> result = productRepository.findById(id);

        if (result.isPresent()) {
            Product product = result.get();

            return productReadRes.builder()
                    .id(product.getId())
                    .price(product.getPrice())
                    .name(product.getName())
                    .build();
        } else {
            return null;
        }
    }
}

    // Update
    // 수정
//    public void update(ProductDto productDto){
//        productRepository.save(Product.builder()
//                .id(productDto.getId())
//                .price(productDto.getPrice())
//                .name(productDto.getName())
//                .build());
//    }

    // Delete
    // 삭제
//    public void delete(Integer id){
//        productRepository.delete(Product.builder().id(id).build());
//    }
//}
