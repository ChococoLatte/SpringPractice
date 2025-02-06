package com.example.spring_practice.order;

import com.example.spring_practice.discount.DiscountPolicy;
import com.example.spring_practice.discount.FixDiscountPolicy;
import com.example.spring_practice.discount.RateDiscountPolicy;
import com.example.spring_practice.member.Member;
import com.example.spring_practice.member.MemberRepository;
import com.example.spring_practice.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

   private final MemberRepository memberRepository;
   private final DiscountPolicy discountPolicy;

   public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy){
       this.memberRepository = memberRepository;
       this.discountPolicy = discountPolicy;
   }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
