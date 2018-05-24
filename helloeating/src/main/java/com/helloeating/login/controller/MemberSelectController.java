package com.helloeating.login.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.helloeating.HelloeatingApplication;
import com.helloeating.login.service.MemberSignService;

@RestController
@RequestMapping("/showuser/")
public class MemberSelectController {
	
	private static final Logger logger = LogManager.getLogger(MemberSelectController.class);
	
	@Autowired
	MemberSignService memberSignService;
	
	@RequestMapping(value="/{ID}", method=RequestMethod.GET)
	public ResponseEntity<List<HashMap<String, Object>>> list (@PathVariable("ID") String ID){
		
		ResponseEntity<List<HashMap<String, Object>>> entity = null;
		
		try {
			entity = new ResponseEntity<>(memberSignService.list(ID), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		logger.info("user selected : [" + ID + "]");
		
		return entity;
	}
}
