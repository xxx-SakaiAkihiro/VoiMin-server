package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.form.DeleteRecordingForm;
import com.example.service.DeleteRecordingService;

/**
 * 録音記録を論理削除するコントローラー.
 * 
 * @author riho.ikeda
 *
 */
@RestController
public class DeleteRecordingController {

	@Autowired
	private DeleteRecordingService deleteRecordingService;

	/**
	 * 録音記録を論理削除する.
	 * 
	 * @param deleteRecordingForm
	 */
	@RequestMapping("/delete")
	public void delete(@RequestBody DeleteRecordingForm deleteRecordingForm) {
		deleteRecordingService.delete(deleteRecordingForm.getRecordingId());
	}

}
