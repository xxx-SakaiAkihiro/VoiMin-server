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

/**
 * ログイン時にユーザー確認を行うコントローラークラス
 * 
 * @author sakai
 */
@RestController
public class LoginCheckController {

	@Autowired
	private FindUserInfoService userService;

	/**
	 * メールアドレスからログインユーザー情報を取得を取得するメソッド.
	 * 
	 * @param param メールアドレス
	 * @return ログインユーザー情報
	 */
	@RequestMapping("/loginCheck")
	public User loginCheck(@RequestBody UserForm userForm) {
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@rakus-partners.co.jp";
		String check2 = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@rakus.co.jp";
		Pattern pattern = Pattern.compile(check);
		Pattern pattern2 = Pattern.compile(check2);
		Matcher matcher = pattern.matcher(userForm.getMailAddress());
		Matcher matcher2 = pattern2.matcher(userForm.getMailAddress());
		
		System.out.println(userService.findByMail(userForm.getMailAddress()));
		return userService.findByMail(userForm.getMailAddress());
	}

}