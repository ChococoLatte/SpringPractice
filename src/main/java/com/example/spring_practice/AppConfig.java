package com.example.spring_practice;

import com.example.spring_practice.discount.DiscountPolicy;
import com.example.spring_practice.discount.FixDiscountPolicy;
import com.example.spring_practice.discount.RateDiscountPolicy;
import com.example.spring_practice.member.*;
import com.example.spring_practice.order.OrderService;
import com.example.spring_practice.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}

