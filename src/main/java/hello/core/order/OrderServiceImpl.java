package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    /**
     * 문제점 발생,
     * DiscountPolicy policy 라는 인터페이스에 의존하지만
     * FixDiscountPolicy라는 구체클래스에도 의존하여
     * 정책변경으로 클라이언트의 소스가 변경되어야 함
     * DIP 위반
     */
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; //final 이 사라진 이유 : final은 값이 할당 되어야 하니깐

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
