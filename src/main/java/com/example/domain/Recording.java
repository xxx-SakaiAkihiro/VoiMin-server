package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

/**
 * 録音のドメインクラス.
 * 
 * @author sakai
 *
 */
@Data
public class Recording {

	/** 録音ID */
	private Integer recordingId;
	/** ユーザーID */
	private Integer userId;
	/** 日付 */
	private Timestamp date;
	/** タイトル */
	private String title;
	/** 内容 */
	private String content;
	/** メンバー */
	private String member;
	/** 備考 */
	private String remarks;
	/** ステータスID */
	private Integer statusId;
	/** 更新日時 */
	private Timestamp updateDate;
	/** バージョン */
	private Integer version;
	
}
