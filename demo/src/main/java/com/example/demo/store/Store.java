package com.example.demo.store;

import com.example.demo.congestion.Congestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Integer id;

    String name;
    String password;

    @JoinColumn(name = "congestion_id")
    @ManyToOne(fetch = FetchType.EAGER)
    Congestion congestion;
}
