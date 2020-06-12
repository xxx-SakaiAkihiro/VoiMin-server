package com.example.form;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * 議事録内容などを登録するフォーム.
 * 
 * @author riho.ikeda
 *
 */
@Data
public class RegisterRecordingForm {

	/** 録音ID */
	private Integer recordingId;
	/** ユーザーID */
	private Integer userId;
	/** 登録日時 */
	private Timestamp date;
	/** タイトル */
	@NotBlank
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
