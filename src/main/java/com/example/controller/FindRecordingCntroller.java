package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Recording;
import com.example.service.FindRecordingService;

/**
 * 録音記録を取得するコントローラー.
 * 
 * @author riho.ikeda
 *
 */
@RestController
public class FindRecordingCntroller {

	@Autowired
	private FindRecordingService findRecordingService;

	/**
	 * 録音記録を取得するコントローラー.
	 * 
	 * @param userId
	 * @return 録音記録
	 */
	public List<Recording> findRecording(Integer userId) {
		return findRecordingService.findRecording(userId);
	}

}
