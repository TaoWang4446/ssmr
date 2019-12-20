package com.ssm.chapter5.chapter4.pojo;

import lombok.Data;

@Data
public class File {
    private long id;
    byte[] content;//和数据库的blob转换,这个时候可以使用系统注册的typeHandler-BolbTypeHandler来转换
}
