//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter15.demo;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.lang.Nullable;

public interface View {
    //响应状态属性
    String RESPONSE_STATUS_ATTRIBUTE = View.class.getName() + ".responseStatus";
    //定义数据模型下取出变量 路径
    String PATH_VARIABLES = View.class.getName() + ".pathVariables";
    //选择响应内容类型
    String SELECTED_CONTENT_TYPE = View.class.getName() + ".selectedContentType";



    /**
     * //响应客户端的类型,
     * @return 字符串,表明用户什么类型的文件响应,可以是html,json,pdf等,而render方法则是一个渲染
     * 视图的方法
     */
    @Nullable
    default String getContentType() {
        return null;
    }

    //渲染视图的方法,
    //通过它就可以渲染视图了,
   // model是数据模型  HTTP请求对象和响应对象用于处理 HTTP请求的各类问题

    void render(@Nullable Map<String, ?> var1, HttpServletRequest var2, HttpServletResponse var3) throws Exception;
}
/**
 * 当控制器返回ModelAndView的时候,视图解析器就会去解析它,然后将数据模型传递给render(),这样就可以
 * 渲染视图了,springmvc中视图的种类很多,jstl视图,json视图,pdf视图等.
 */
