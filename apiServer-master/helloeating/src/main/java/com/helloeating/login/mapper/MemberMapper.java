package com.helloeating.login.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.helloeating.login.domain.MemberVO;

@Mapper
public interface MemberMapper {
	    
	public int TESTCount() throws Exception;
	void InsertMember(MemberVO memberVO);
	
	public List<HashMap<String, Object>> list(String ID) throws Exception;
	
	public int user_login(Map<String, Object> map) throws Exception;
	
	public int token_login(Map<String, Object> map) throws Exception;
	
	public void update_logintoken (Map<String, Object> map) throws Exception;
}
