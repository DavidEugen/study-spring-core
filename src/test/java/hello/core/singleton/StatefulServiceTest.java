package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 컨테이너가 상태를 가지게 될때 문제점")
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

//        //A 사용자 10000원 주문
//        statefulService1.order("userA",10000);
//        //B 사용자 20000원 주문
//        statefulService2.order("userB",20000);
//
//        //A 사용자의 금액 10000원 예상
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
//
        //A 사용자 10000원 주문
        int priceA = statefulService1.order("userA",10000);
        //B 사용자 20000원 주문
        int priceB = statefulService2.order("userB",20000);

        //A 사용자의 금액 10000원 예상
        System.out.println("priceA = " + priceA);

        Assertions.assertThat(priceA).isEqualTo(10000);

    }


    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}