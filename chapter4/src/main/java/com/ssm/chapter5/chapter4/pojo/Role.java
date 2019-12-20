package com.ssm.chapter5.chapter4.pojo;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("role")
public class Role {

	private Long id;
	private String roleName;
	private String note;

}