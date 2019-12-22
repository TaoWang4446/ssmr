//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter16.demo;

import java.io.IOException;
import java.util.List;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;

/**
 * HttpMessageConverter 接口定义
 * 定义从HTTP接收请求消息和应答给用户的,
 * @param <T>
 */
public interface HttpMessageConverter<T> {
    /**
     * 判断是否可读,class是类别,mediatype是HTTP类型
     * @param var1
     * @param var2
     * @return
     */
    boolean canRead(Class<?> var1, @Nullable MediaType var2);

    /**
     * 判断是否可写,class是类别,mediatype是HTTP类型
     * @param var1
     * @param var2
     * @return
     */
    boolean canWrite(Class<?> var1, @Nullable MediaType var2);

    /**
     * 对于mediatype是HTTP的类型
     * @return
     */
    List<MediaType> getSupportedMediaTypes();

    /**
     * 读取数据类型,进行转换,clazz是类,inptMesaage是请求消息,
     * @param var1
     * @param var2
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    T read(Class<? extends T> var1, HttpInputMessage var2) throws IOException, HttpMessageNotReadableException;

    /**
     * 写消息,contentType是http类型,outputmessage是HTTP的应答消息
     * @param var1
     * @param var2
     * @param var3
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    void write(T var1, @Nullable MediaType var2, HttpOutputMessage var3) throws IOException, HttpMessageNotWritableException;
}
