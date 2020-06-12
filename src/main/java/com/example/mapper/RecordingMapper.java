package com.example.mapper;

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
	 * 議事録内容を登録する.
	 * 
	 * @param recording 議事録内容
	 */
	public  void registerRecording(Recording recording);

}
