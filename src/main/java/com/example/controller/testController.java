package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * フロントとAPIをつなげるテスト
 * 
 * @author riho.ikeda
 *
 */
@RestController
@RequestMapping("")
public class testController {

	@RequestMapping("/test")
	public String test(String fromtParm) {
		System.out.println(fromtParm);
		String test = "サーバーテスト成功";
		return test;
	}

}
