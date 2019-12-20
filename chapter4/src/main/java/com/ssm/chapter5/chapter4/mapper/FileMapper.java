package com.ssm.chapter5.chapter4.mapper;

import com.ssm.chapter5.chapter4.pojo.File;

public interface FileMapper {
	public File getFile(Long id);
	public void insertFile(File file);
}
