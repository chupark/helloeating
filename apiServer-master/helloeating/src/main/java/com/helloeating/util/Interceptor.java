package com.helloeating.util;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.helloeating.common.CommandMap;
import com.helloeating.login.domain.MemberVO;
import com.helloeating.login.service.MemberSignService;

@Component
public class Interceptor implements HandlerInterceptor{
	
	private static final Logger logger = LogManager.getLogger(Interceptor.class);
	
	@Autowired
	MemberSignService memberSignService;
	
	
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {		
		logger.info("=============== Before Method");
		
		String id = request.getParameter("id");
		String loginToken = request.getParameter("loginToken");
		
		Map map = new HashMap();
		map.put("id", id);
		map.put("loginToken", loginToken);
		System.out.println(map);
		
		
		if (id == null || loginToken == null) {
			logger.info("id와 토큰이 없음");
			
			response.sendRedirect("/error/er1000");
			return false;
		} else if (id != null && loginToken != null) {
			
			if(memberSignService.token_login(map) == 1){
				logger.info("토큰 로그인 성공 ["+loginToken+"]");
				return true;	
			} else {
				logger.info("실패실패");
				response.sendRedirect("/error/er1010");
				return false;
			}
			
		} else {
			logger.info("else // 알수없는 에러");
			
			response.sendRedirect("/error/er1000");
			return false;
		}
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		logger.info("=============== Method Executed");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.info("=============== Method Completed");
		
	}

}
