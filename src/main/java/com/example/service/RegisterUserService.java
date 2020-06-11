package com.example.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.mapper.UserMapper;

/**
 * ユーザー情報を登録を行うサービス.
 * 
 * @author sakai
 *
 */
@Service
@Transactional
public class RegisterUserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param userForm ユーザー名とメールアドレス
	 * @return ユーザー情報
	 */
	public void registerUser(UserForm userForm) {
		Timestamp tsDate = new Timestamp(System.currentTimeMillis()); // 現在時刻を生成
		User user = new User();
		user.setUserName(userForm.getUserName());
		user.setMailAddress(userForm.getMailAddress());
		user.setRegisterDate(tsDate);
		user.setStatusId(1);
		userMapper.registerUser(user); // usersテーブルに挿入
	}
}
