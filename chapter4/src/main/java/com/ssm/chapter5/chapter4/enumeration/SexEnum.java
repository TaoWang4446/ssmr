package com.ssm.chapter5.chapter4.enumeration;

public enum SexEnum {
	MALE(0, "男"),
	FEMALE(1, "女");

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	SexEnum(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public static SexEnum getSexById(int id) {
		for (SexEnum sex : SexEnum.values()) {
			if (sex.getId() == id) {
				return sex;
			}
		}
		return null;
	}
}
