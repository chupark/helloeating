package com.helloeating.login.errorpage;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/error/")
public class ErrorController {

	@RequestMapping(value="/er1000")
	public String needLogin() {
		
		return "로그인이 필요합니다";
	}
	@RequestMapping(value="/er1010")
	public String needLogin2() {
		
		return "잘못된 토큰 또는 id";
	}
}
