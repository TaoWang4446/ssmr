package com.wst.chapter2.factory.abstractFactory;

public class Product2 implements IProduct {
    @Override
    public void createProduct() {
        System.out.println("创建product2..");
    }
}
