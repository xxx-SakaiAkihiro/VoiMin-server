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
//import com.example.service.RegisterPasswordService;
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

	@Autowired
	private RegisterUserService registerUserService;
	
//	@Autowired
//	private RegisterPasswordService registerPasswordService;
	

	/**
	 * メールアドレスからユーザー情報を取得する.
	 * 
	 * @param userForm メールアドレス
	 * @return ユーザ情報
	 */
	@RequestMapping("/loginCheck")
	public User loginCheck(@RequestBody UserForm userForm) {
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@rakus-partners.co.jp";
		String check2 = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@rakus.co.jp";
		Pattern pattern = Pattern.compile(check);
		Pattern pattern2 = Pattern.compile(check2);
		Matcher matcher = pattern.matcher(userForm.getMailAddress());
		Matcher matcher2 = pattern2.matcher(userForm.getMailAddress());

		if (matcher.matches() || matcher2.matches()) {
			/** ユーザ情報の取得 */
			User loginCheck = findUserInfoService.findByMail(userForm.getMailAddress());
			/** ユーザ情報がない場合 */
			if (loginCheck == null) {
				/** ユーザ情報を登録する */
				registerUserService.registerUser(userForm);
				return findUserInfoService.findByMail(userForm.getMailAddress());
			} else {
				/** ユーザ情報がある場合 */
				return loginCheck;
			}
		} else {
			/** 組織外ユーザーによるログインであった場合 */
			User user = new User();
			user.setStatusId(2);
			return user;
		}
	}
}
