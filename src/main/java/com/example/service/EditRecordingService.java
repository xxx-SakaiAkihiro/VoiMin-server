package com.example.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Recording;
import com.example.form.RecordingForm;
import com.example.mapper.RecordingMapper;

/**
 * 録音記録を編集するサービス.
 * 
 * @author sakai
 *
 */
@Service
@Transactional
public class EditRecordingService {

	@Autowired
	private RecordingMapper recordingMapper;

	/**
	 * 録音記録を更新する.
	 * 
	 * @param recordingForm form
	 */
	public void edit(RecordingForm recordingForm) {
		String title = recordingForm.getTitle();
		String member = recordingForm.getMember();
		String remarks = recordingForm.getRemarks();
		String content = recordingForm.getContent();
		Timestamp updateDate = new Timestamp(System.currentTimeMillis()); // 現在時刻を生成
		Integer recordingId = recordingForm.getRecordingId();
		recordingMapper.update(title, member, remarks, content, updateDate, recordingId);
	}
}
