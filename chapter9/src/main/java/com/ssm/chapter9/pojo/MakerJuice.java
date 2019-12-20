package com.ssm.chapter9.pojo;

import lombok.Data;


@Data
public class MakerJuice {
    private String beverageShop = null;
    private Source source = null;


    public String makeJuice() {
        String juice = "这是一杯由" + beverageShop + "饮品店，提供的" + source.getSize() + source.getSugar() + source.getFruit();
        return juice;
    }

}
