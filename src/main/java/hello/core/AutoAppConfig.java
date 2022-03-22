package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        excludeFilters = @Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class))
//@Configuration component상속, 기존에 테스트 하던 수동 등록 빈들도 다 불러오기에 제외 시킨다.
public class AutoAppConfig {
}
