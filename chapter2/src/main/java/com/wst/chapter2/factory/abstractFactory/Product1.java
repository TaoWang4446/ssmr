package com.wst.chapter2.factory.abstractFactory;

public class Product1 implements IProduct {
    @Override
    public void createProduct() {
        System.out.println("创建product1..");
    }
}
