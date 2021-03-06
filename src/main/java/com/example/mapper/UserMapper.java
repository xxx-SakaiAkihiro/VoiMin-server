package com.example.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.User;

/**
 * ユーザーマッパー.
 * 
 * @author sakai
 *
 */
@Mapper
public interface UserMapper {

	/**
	 * メールアドレスからユーザー情報を取得する.
	 * 
	 * @param mail メール
	 * @return ユーザー情報
	 */
	public User findByMail(String mail);
	
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param user ユーザ情報
	 */
	public void registerUser(User user);
	
}
