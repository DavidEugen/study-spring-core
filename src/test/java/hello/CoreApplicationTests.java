package hello;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@SpringBootTest
@ComponentScan(
		excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
class CoreApplicationTests {

	@Test
	void contextLoads() {
	}

}
