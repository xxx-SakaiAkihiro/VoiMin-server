package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.RecordingForm;
import com.example.service.EditRecordingService;

/**
 * 録音記録を編集するコントローラー.
 * 
 * @author sakai
 *
 */
@RestController
public class EditRecordingController {

	@Autowired
	private EditRecordingService editRecordingService;
	
	/**
	 * 録音記録を更新する.
	 * 
	 * @param recordingForm 更新情報
	 */
	@RequestMapping("/edit")
	public void edit(@RequestBody RecordingForm recordingForm) {
		editRecordingService.edit(recordingForm);
	}
	
}
