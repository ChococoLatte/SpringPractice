package com.example.spring_practice.discount;

import com.example.spring_practice.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);
}
