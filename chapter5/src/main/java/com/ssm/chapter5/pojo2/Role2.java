package com.ssm.chapter5.pojo2;

import lombok.Data;

import java.util.List;

@Data
public class Role2 {
	private Long id;
	private String roleName;
	private String note;
	// 关联用户信息，一对多关联
	private List<User2> userList;

}
