package com.example.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.error.ExclusiveException;
import com.example.form.SignInUserForm;
import com.example.service.RegisterPasswordService;

/**
 * パスワード登録をするコントローラー.
 * 
 * @author sakai
 *
 */
@RestController
public class RegisterPasswordController {

	@Autowired
	private RegisterPasswordService registerPasswordService;

	/**
	 * パスワード登録をするメソッド.
	 * 
	 * @param form リクエストパラメータ
	 */
	@PostMapping("/signUp")
	public void signUp(@RequestBody(required = false) @Valid SignInUserForm form) throws ExclusiveException {
		String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@rakus-partners.co.jp";
		String check2 = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@rakus.co.jp";
		Pattern pattern = Pattern.compile(check);
		Pattern pattern2 = Pattern.compile(check2);
		Matcher matcher = pattern.matcher(form.getMailAddress());
		Matcher matcher2 = pattern2.matcher(form.getMailAddress());
		if (matcher.matches() || matcher2.matches()) {
			registerPasswordService.registerApiUser(form);
		} else {
			throw new ExclusiveException("入力値が違法です");
		}
	}

}