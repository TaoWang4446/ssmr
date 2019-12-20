package com.ssm.chapter5.chapter4.pojo;

import com.ssm.chapter5.chapter4.enumeration.SexEnum;
import lombok.Data;

@Data
public class User {
	private Long id;
	private String userName;
	private String password;
	private SexEnum sex;
	private String mobile;
	private String tel;
	private String email;
	private String note;
}