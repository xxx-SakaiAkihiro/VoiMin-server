package com.example.domain;

import lombok.Data;

/**
 * 状態区分のドメインクラス.
 * 
 * @author sakai
 *
 */
@Data
public class StatusMemo {

	/** ステータスID */
	private Integer statusId;
	/** ステータス名 */
	private String statusName;
}
