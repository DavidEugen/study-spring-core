package hello.core.beandefinition;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BeanDefinitionTest {

    // javaconfig 든 xml이든 우리가 bean을 설정 형식 다양하게 사용하는것은 BeanDefinition 이라는 추상화가 있기 때문이다.
    // BeanDefinition을 빈 설정 메타 정보라고 한다. @Bean, <bean> 당 각각 하나씩 메타 정보가 생성 된다.
//    ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    //    bean을 직접 등록하기도 하지만 javaconfig 에서 처럼 factoryMethod 방식으로 bean을 생성하기도 한다.


    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // ac 가 ApplicationContext 아니라 AnnotationConfigApplicationContext 인 이유 getBeanDefinition을 못쓴다.
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);

            }
        }

    }

}
