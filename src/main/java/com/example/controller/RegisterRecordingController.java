package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.form.RecordingForm;
import com.example.service.RegisterRecordingService;

/**
 * 議事録内容を記録するコントローラー.
 * 
 * @author riho.ikeda
 *
 */
@RestController
public class RegisterRecordingController {

	@Autowired
	private RegisterRecordingService registerRecordingService;

	/**
	 * 議事録内容を登録する.
	 * 
	 * @param registerRecordingForm 議事録内容
	 */
	@RequestMapping("/registerRecording")
	public void registerRecording(@RequestBody RecordingForm registerRecordingForm) {
		registerRecordingService.registerRecording(registerRecordingForm);
	}
	
}
