package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.FindUserInfoService;
import com.example.service.RegisterUserService;

/**
 * ユーザー情報を登録を行うコントローラー.
 * 
 * @author sakai
 *
 */
@RestController
public class RegisterUserController {

	@Autowired
	private RegisterUserService registerUserService;
	private FindUserInfoService findUserInfoService;

	public UserForm setUpForm() {
		return new UserForm();
	}

	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param userForm ユーザー名とメールアドレス
	 * @return ユーザー情報
	 */
	@RequestMapping("/registerUser")
	public User registerUser(@RequestBody UserForm userForm) {
		registerUserService.registerUser(userForm);
		return registerUserService.select(userForm);
	}

}
