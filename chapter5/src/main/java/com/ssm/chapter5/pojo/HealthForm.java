package com.ssm.chapter5.pojo;

import lombok.Data;

@Data
public class HealthForm {
	
	private Long id;
	private Long empId;
	private String heart;
	private String liver;
	private String spleen;
	private String lung;
	private String kidney;
	private String note;

}
