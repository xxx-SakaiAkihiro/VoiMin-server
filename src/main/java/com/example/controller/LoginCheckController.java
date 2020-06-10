package com.example.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.FindUserInfoService;
import com.example.service.RegisterUserService;

/**
 * ログイン時にユーザー確認を行うコントローラー.
 * 
 * @author sakai
 */
@RestController
public class LoginCheckController {

	@Autowired
	private FindUserInfoService findUserInfoService;
	private RegisterUserService registerUserService;

	/**
	 * メールアドレスからユーザー情報を取得する.
	 * 
	 * @param userForm メールアドレス
	 * @return ユーザ情報
	 */
	@RequestMapping("/loginCheck")
	public User loginCheck(@RequestBody UserForm userForm) {
		User loginCheck = findUserInfoService.findByMail(userForm.getMailAddress());
		System.out.println("１："+loginCheck);
		System.out.println("外"+userForm);
		if (loginCheck == null) {
			System.out.println("中"+userForm);
			registerUserService.registerUser(userForm);
			return registerUserService.select(userForm);
		} else {
			return loginCheck;
		}
	}
}
