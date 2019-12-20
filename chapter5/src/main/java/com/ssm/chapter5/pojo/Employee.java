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
    //工牌按一对一级联
	private WorkCard workCard;
	//雇员任务，一对多级联
	private List<EmployeeTask> employeeTaskList = null;
}
