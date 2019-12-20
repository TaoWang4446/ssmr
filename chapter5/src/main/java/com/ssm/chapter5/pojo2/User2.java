package com.ssm.chapter5.pojo2;

import java.util.List;

import com.ssm.chapter5.enumeration.SexEnum;
import lombok.Data;

@Data
public class User2 {
	private Long id;
	private String userName;
	private String realName;
	private SexEnum sex;
	private String moble;
	private String email;
	private String note;
	// �Խ�ɫһ�Զ����
	private List<Role2> roleList;


}
