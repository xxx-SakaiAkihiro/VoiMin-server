package com.example.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Password {

	private Integer passwordId;
	private String mailAddress;
	private String password;
	private Timestamp registerDate;
}
