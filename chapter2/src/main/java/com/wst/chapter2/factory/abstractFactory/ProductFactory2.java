package com.wst.chapter2.factory.abstractFactory;

public class ProductFactory2 implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = new Product2();//工厂2生产产品对象规则,可以是一类产品的规则.
        System.out.println("create product2");
        return product;
    }
}
