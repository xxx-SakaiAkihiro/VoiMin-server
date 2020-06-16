package com.example.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Recording;
import com.example.mapper.RecordingMapper;

/**
 * 録音記録を論理削除する.
 * 
 * @author riho.ikeda
 *
 */
@Service
@Transactional
public class DeleteRecordingService {
	
	@Autowired
	private RecordingMapper recordingMapper;
	
	/**
	 * 録音記録を論理削除する.
	 * 
	 * @param recordingId
	 */
	public void delete(Integer recordingId) {
		Timestamp tsDate = new Timestamp(System.currentTimeMillis()); // 現在時刻を生成
		Recording recording = new Recording();
		
		recording.setUpdateDate(tsDate);
		recording.setStatusId(3);
		recording.setRecordingId(recordingId);
		System.out.println(recording);
		
		recordingMapper.delete(recording);
	}
}
