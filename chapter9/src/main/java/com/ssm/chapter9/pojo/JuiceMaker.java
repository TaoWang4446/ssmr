package com.ssm.chapter9.pojo;

import lombok.Data;

/**
 * 果汁生成器
 */
@Data
public class JuiceMaker {
	private Blender blender = null;// 搅拌机
	private String water;// 水描述
	private String fruit;// 水果
	private String sugar;// 糖分描述

	/**
	 * 果汁生成
	 */
	public String makeJuice() {
		blender = new Blender();
		return blender.mix(water, fruit, sugar);
	}
}
