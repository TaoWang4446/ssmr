package com.ssm.chapter9.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Data
//@Component(value = "role")
//@ComponentScan//扫描当前包的bean
public class Role {

    //@Value("1")
    private Long id;
    private String roleName;
    private String note;

    public Role(String roleName,String note){
        this.roleName = roleName;
        this.note = note;
    }

}
