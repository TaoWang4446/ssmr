package com.ssm.chapter8.params;

import lombok.Data;

@Data
public class PageParams {
	// 当前页码
	private Integer page;
	// 每页限制条数
	private Integer pageSize;
	// 是否启动插件，如果不启动，则不作分页
	private Boolean useFlag;
	// 是否检测页码的有效性，如果为true，而页码大于最大页数，则抛出异常
	private Boolean checkFlag;
	// 是否清除最后order by后面的语句
	private Boolean cleanOrderBy;
	// 总条数，插件会回填这个值
	private Integer total;
	// 总页数，插件会回填这个值.
	private Integer totalPage;

}
