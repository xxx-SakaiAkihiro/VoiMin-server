package com.example.service;

import java.sql.Timestamp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Recording;
import com.example.form.RecordingForm;
import com.example.mapper.RecordingMapper;

/**
 * 議事録内容を登録するサービス.
 * 
 * @author riho.ikeda
 *
 */
@Service
@Transactional
public class RegisterRecordingService {
	
	@Autowired
	private RecordingMapper registerRecordingMapper;
	
	
	/**
	 * 議事録内容を登録する.
	 * 
	 * @param recording 議事録内容
	 */
	public void registerRecording(RecordingForm registerRecordingForm) {
		Timestamp tsDate = new Timestamp(System.currentTimeMillis()); // 現在時刻を生成
		Recording recording = new Recording();
		
		recording.setUserId(registerRecordingForm.getUserId());
		recording.setDate(tsDate);
		recording.setTitle(registerRecordingForm.getTitle());
		recording.setContent(registerRecordingForm.getContent());
		recording.setMember(registerRecordingForm.getMember());
		recording.setRemarks(registerRecordingForm.getRemarks());
		recording.setStatusId(1);
		recording.setVersion(1);
		registerRecordingMapper.registerRecording(recording);
		
	}
	
	
	

}
