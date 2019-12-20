package com.ssm.chapter5.param;

import lombok.Data;

import java.util.Date;

@Data
public class PdCountRoleParams {

	private String roleName;
	private int total;
	private Date execDate;

}
