package com.example.demo.orders.model;

import com.example.demo.member.model.Member;
import com.example.demo.product.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    // 다 쪽에 외래키 지정

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Member_id")
    Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Product_id")
    Product product;

    Integer orderTime;

    String orderStatus;







}
