package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleToneTest {

    @Test
    @DisplayName("스프링이 없는 순수한 DI 컨테이너 - 싱클톤이 아닌 경우")
    void puerContainer() {
        //싱글톤이 아닌 경우 메소드 팩토리 형식에 의해 성성된 new 는 서로 다른 객체를 생성한다.
        AppConfig appConfig = new AppConfig();

        //호출시 마다 객체 생성 -1
        MemberService memberService1 = appConfig.memberService();
        //호출시 마다 객체 생성 -2
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //isSameAs -> ==
        //isEqual -> Equals
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

}
