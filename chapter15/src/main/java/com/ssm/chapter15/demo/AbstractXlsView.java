//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter15.demo;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.AbstractView;

public abstract class AbstractXlsView extends AbstractView {
    public AbstractXlsView() {
        this.setContentType("application/vnd.ms-excel");
    }

    protected boolean generatesDownloadContent() {
        return true;
    }

    protected final void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Workbook workbook = this.createWorkbook(model, request);
        this.buildExcelDocument(model, workbook, request, response);
        response.setContentType(this.getContentType());
        this.renderWorkbook(workbook, response);
    }

    protected Workbook createWorkbook(Map<String, Object> model, HttpServletRequest request) {
        return new HSSFWorkbook();
    }

    protected void renderWorkbook(Workbook workbook, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        workbook.close();
    }

    /**
     * 此方法的主要任务是:创建一个workbook,要用到poi的api,自行下载导入到项目中,springmvc已经对导出excel进行了很多的封装.
     * 假设要导出所有的角色信息,未来还要导出其他info,为了方便,先
     * 定义一个接口,这个接口主要让开发者自定义生成excel的规则.
     * @param model spirngmvc 数据模型
     * @param workbook poi workbook对象
     * @param request HTTP请求对象
     * @param response HTTP响应对象
     * @throws Exception
     */
    protected abstract void buildExcelDocument(Map<String, Object> var1, Workbook var2, HttpServletRequest var3, HttpServletResponse var4) throws Exception;
}
