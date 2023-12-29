package com.example.demo.cart.model;

import com.example.demo.member.model.Member;
import com.example.demo.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Cart {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_id")
    Product product;

}
