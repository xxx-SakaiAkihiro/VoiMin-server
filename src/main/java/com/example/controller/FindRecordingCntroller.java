package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Recording;
import com.example.form.RecordingForm;
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
	@RequestMapping("/findRecording")
	public List<Recording> findRecording(@RequestBody RecordingForm recordingForm) {
		return findRecordingService.findRecording(recordingForm.getUserId());
	}

}
