package com.helloeating.DemoController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	@RequestMapping("/")
    public @ResponseBody String root_test() throws Exception{
        return "Hello World";
    }

	@RequestMapping("/demo")
    public @ResponseBody String demo_test() throws Exception{
        return "데모 페이지에 접속 하셨습니다.";
    }
}
