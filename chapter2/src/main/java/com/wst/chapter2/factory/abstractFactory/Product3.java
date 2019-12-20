package com.wst.chapter2.factory.abstractFactory;

public class Product3 implements IProduct {
    @Override
    public void createProduct() {
        System.out.println("创建product3..");
    }
}
