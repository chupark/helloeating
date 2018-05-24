package com.helloeating.login.controller;


import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.helloeating.common.CommandMap;
import com.helloeating.login.domain.MemberVO;
import com.helloeating.login.service.MemberSignService;

@RestController
@RequestMapping(value = "/user/")
public class MemberRegisterController {
	
	private static final Logger logger = LogManager.getLogger(MemberSelectController.class);
	
	@Autowired
	MemberSignService memberSignService;
	
	@RequestMapping(value = "/signup")
	public String memberRegisterForm(MemberVO memberVO) {
	
		return "그냥있는페이지";
	}
	
	@RequestMapping(value = "/eat1000")
	public String memberRegister(MemberVO memberVO) {
		
		if (memberVO.getMember_id() == null) {
			logger.info("/user/memberinsert [id 미입력]");
			return "id를 입력해주세요";
		} else if (memberVO.getMember_password() == null){
			logger.info("/user/memberinsert [비밀번호 미입력]");
			return "비밀번호를 입력해주세요";			
		} else if (memberVO.getDevice_token() == null) {
			logger.info("/user/memberinsert [디바이스 정보 누락]");
			return "디바이스 정보 누락";
		} else if (memberVO.getOs_type() == null){
			logger.info("/user/memberinsert [OS 정보 누락]");
			return "OS 정보 누락";
		} else {
			if(memberVO.getMember_nickname() == null) {
				memberVO.setMember_nickname(memberVO.getMember_id());
			}
			
			memberSignService.InsertMember(memberVO);
			
			logger.info("유저 등록 완료 ["+ memberVO.getMember_id() +"]");
			return "memberinsert OK";	
		}
	}
	
	@RequestMapping(value = "/eat2000")
	public String memberLogin (HttpServletRequest request, CommandMap commandMap) throws Exception {
		commandMap.clear();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		commandMap.put("id", id);
		commandMap.put("password", password);
		String uuid_token = UUID.randomUUID().toString();
		
		if(id.length() > 0 && password.length() > 0) {
			if (memberSignService.user_login(commandMap.getMap()) == 0) {
				return "id 또는 비밀번호를 확인 해주세요";
			}else if(memberSignService.user_login(commandMap.getMap()) == 1) {
				commandMap.put("login_token", uuid_token);
				
				memberSignService.update_logintoken(commandMap.getMap());
				return uuid_token;
			}else {
				return "알 수 없는 오류 관리자에게 문의";
			}
		}else {
			return "id 와 비밀번호를 모두 입력 해주세요";
		}
	}
	
	@RequestMapping(value = "/eat2010")
	public String tokenLogin (HttpServletRequest request, CommandMap commandMap) throws Exception {
		commandMap.clear();
		String loginToken = request.getParameter("loginToken");
		String id = request.getParameter("id");
		
		commandMap.put("id", id);
		commandMap.put("loginToken", loginToken);
		
		if (loginToken.length() <= 0 || id.length() <= 0) {
			return "로그인 정보가 필요합니다";
		}else {
			if(memberSignService.token_login(commandMap.getMap()) == 1) {
				return "login_OK";
			} else if (memberSignService.token_login(commandMap.getMap()) == 0) {
				return "login_fail";
			} else {
				return "아몰라 에러";
			}
		}
	}
}
