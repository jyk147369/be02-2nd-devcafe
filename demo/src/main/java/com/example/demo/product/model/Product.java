package com.example.demo.product.model;

import com.example.demo.orders.model.Orders;
import com.example.demo.store.Store;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;
    Integer price;
    String size;

    // product가 1 주인지정
    @OneToMany(mappedBy = "product")
    List<Orders> ordersList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="store_id")
    Store store;
}
