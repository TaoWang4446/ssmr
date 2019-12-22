package com.ssm.chapter15.view;

import java.util.Map;
import org.apache.poi.ss.usermodel.Workbook;
public interface ExcelExportService {
	
	/***
	 *  生成exel文件规则
	 * @param model 数据模型
	 * @param workbook excel workbook
	 *
	 *                 有了这个接口,还需要一个可实例化的Excel视图类,=ExcelView
	 */
	public void makeWorkBook(Map<String, Object> model, Workbook workbook);

}