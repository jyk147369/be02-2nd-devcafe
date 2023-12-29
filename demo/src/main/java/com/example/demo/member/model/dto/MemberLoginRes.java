package com.example.demo.member.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.criteria.CriteriaBuilder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRes {
    String email;
    Integer id;
}
