package com.helloeating.login.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.helloeating.login.domain.MemberVO;

public interface MemberSignService {

	public int TESTCount() throws Exception;
	
	void InsertMember(MemberVO memberVO);
	
	public List<HashMap<String, Object>> list (String ID) throws Exception;
	
	public int user_login(Map<String, Object> map) throws Exception;

	public int token_login(Map<String, Object> map) throws Exception;
	
	public void update_logintoken (Map<String, Object> map) throws Exception;
}
