package com.ssm.chapter5.pojo;

import java.util.Date;
import java.util.List;

import com.ssm.chapter5.enumeration.SexEnum;
import lombok.Data;

@Data
public class Employee {

	private Long id;
	private String realName;
	private SexEnum sex = null;
	private Date birthday;
	private String mobile;
	private String email;
	private String position;
	private String note;
    //���ư�һ��һ����
	private WorkCard workCard;
	//��Ա����һ�Զ༶��
	private List<EmployeeTask> employeeTaskList = null;
}
