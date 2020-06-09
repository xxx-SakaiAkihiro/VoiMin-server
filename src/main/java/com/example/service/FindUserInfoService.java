package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
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
		User loginUser = new User();
		try {
			loginUser = userMapper.findByMail(mail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// ユーザー情報がない(nullだった)場合
//		if (loginUser == null) {
//		}

		// ユーザー情報がある場合
		return loginUser;
	}

}
