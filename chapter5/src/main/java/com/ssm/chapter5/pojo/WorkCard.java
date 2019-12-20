package com.ssm.chapter5.pojo;

import lombok.Data;

@Data
public class WorkCard {
	private Long id;
	private Long empId;
	private String realName;
	private String department;
	private String mobile;
	private String position;
	private String note;

}
