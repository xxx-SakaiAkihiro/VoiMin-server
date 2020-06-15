package com.example.form;

import lombok.Data;

/**
 * 録音記録を取得する際、引数をフロント側からもらうフォーム.
 * 
 * @author riho.ikeda
 *
 */
@Data
public class FindRecordingForm {
	
	/** ユーザーID */
	private Integer userId;

}
