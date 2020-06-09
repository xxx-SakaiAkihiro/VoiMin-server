package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

/**
 * ユーザー情報のドメインクラス.
 * 
 * @author sakai
 *
 */
@Data
public class User {

	/** ユーザーID */
	private Integer userId;
	/** ユーザー名 */
	private String userName;
	/** メールアドレス */
	private String mailAddress;
	/** 登録日時 */
	private Timestamp registerDate;
	/** ステータスID */
	private Integer statusId;

}
