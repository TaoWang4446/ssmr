package com.wst.chapter2.factory.abstractFactory;

public class ProductFactory1 implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = new Product1();//工厂1生产产品对象规则,可以是一类产品的规则.
        System.out.println("create product1");
        return product;
    }
}
