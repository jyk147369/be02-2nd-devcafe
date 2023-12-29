package com.example.demo.member.model;

import com.example.demo.orders.model.Orders;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String email;
    String password;
    String pic;

    // 1 쪽에 주인 지정
    @OneToMany(mappedBy = "member")
    List<Orders> ordersList = new ArrayList<>();
}
