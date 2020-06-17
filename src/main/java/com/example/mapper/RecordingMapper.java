package com.example.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.domain.Recording;

/**
 * 議事録内容などを登録するマッパー
 * 
 * @author riho.ikeda
 *
 */
@Mapper
public interface RecordingMapper {
	/**
	 * userIdとstatusIdで絞り込みrecordingListをSELECTする.
	 * 
	 * @param userId
	 * @param statusId
	 * @return 録音記録
	 */
	public List<Recording> findByUserIdAndStausId(Integer userId, Integer statusId);

	/**
	 * 議事録内容を登録する.
	 * 
	 * @param recording 議事録内容
	 */
	public void registerRecording(Recording recording);

	/**
	 * 録音記録を論理削除する.
	 * 
	 * @param recordingId
	 */
	public void delete(Recording recording);

	/**
	 * 録音記録を更新する.
	 * 
	 * @param title       タイトル
	 * @param member      メンバー
	 * @param remarks     備考
	 * @param content     投稿内容
	 * @param updateDate  更新日時
	 * @param recordingId 投稿ID
	 */
	public void update(String title, String member, String remarks, String content, Timestamp updateDate,
			Integer recordingId);
}
