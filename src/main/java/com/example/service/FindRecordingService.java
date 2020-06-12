package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Recording;
import com.example.mapper.RecordingMapper;

/**
 * 録音記録を取得するサービス.
 * 
 * @author riho.ikeda
 *
 */
@Service
@Transactional
public class FindRecordingService {

	@Autowired
	private RecordingMapper recordingMapper;

	/**
	 * 録音記録を取得する.
	 * 
	 * @param userId 
	 * @param statusId
	 * @return 録音記録
	 */
	public List<Recording> findRecording(Integer userId) {
		return recordingMapper.findByUserIdAndStausId(userId, 1);
	}

}
