package com.example.demo.card.model;


import com.example.demo.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String cardInfo;
    Integer cardExpdate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Member_id")
    Member member;
}
