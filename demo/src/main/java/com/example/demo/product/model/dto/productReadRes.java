package com.example.demo.product.model.dto;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class productReadRes {
    Integer id;
    String name;
    Integer price;

}
