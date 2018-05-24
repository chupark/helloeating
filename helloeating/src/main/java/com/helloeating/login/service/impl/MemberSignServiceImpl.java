package com.helloeating.login.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helloeating.login.domain.MemberVO;
import com.helloeating.login.mapper.MemberMapper;
import com.helloeating.login.service.MemberSignService;

@Service
public class MemberSignServiceImpl implements MemberSignService{

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public int TESTCount() throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.TESTCount();
	}

	@Override
	public void InsertMember(MemberVO memberVO) {
		// TODO Auto-generated method stub
		memberMapper.InsertMember(memberVO);
	}

	@Override
	public List<HashMap<String, Object>> list(String ID) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.list(ID);
	}

	@Override
	public int user_login(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.user_login(map);
	}

	@Override
	public void update_logintoken(Map<String, Object> map) throws Exception {

		memberMapper.update_logintoken(map);		
	}

	@Override
	public int token_login(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return memberMapper.token_login(map);
	}
}
