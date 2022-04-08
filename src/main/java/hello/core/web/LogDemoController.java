package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	private final MyLogger myLogger;

	@RequestMapping("log-demo")
	@ResponseBody
	// public String logDemo(HttpServletRequest request) { // InterruptedException; must be caught or declared to be thrown
	public String logDemo(HttpServletRequest request) throws InterruptedException {

		//실제는 프록시 객체가 생성이 되어 있다.
		System.out.println("myLogger in controller = " + myLogger.getClass());
		String requestURL = request.getRequestURL().toString();

		myLogger.setRequestURL(requestURL);

		myLogger.log("controller test");
		Thread.sleep(1000);
		logDemoService.logic("testId");
		return "OK";
	}
}
