package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.mapper.UserMapper;

/**
 * ユーザー情報を取得するサービス.
 * 
 * @author sakai
 *
 */
@Service
@Transactional
public class FindUserInfoService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * メールアドレスからユーザー情報を取得する.
	 * 
	 * @param mail メールアドレス
	 * @return ユーザ情報
	 */
	public User findByMail(String mail) {
		return userMapper.findByMail(mail);
	}

}
