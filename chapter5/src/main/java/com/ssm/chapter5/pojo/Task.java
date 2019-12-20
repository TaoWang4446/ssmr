package com.ssm.chapter5.pojo;

import lombok.Data;

@Data
public class Task {
	private Long id;
	private String title;
	private String context;
	private String note;
}
