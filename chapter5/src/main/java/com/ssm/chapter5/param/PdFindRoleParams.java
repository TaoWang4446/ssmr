package com.ssm.chapter5.param;

import java.util.List;

import com.ssm.chapter5.pojo.Role;
import lombok.Data;

@Data
public class PdFindRoleParams {
	private String roleName;
	private int start;
	private int end;
	private int total;
	private List<Role> roleList;

}
