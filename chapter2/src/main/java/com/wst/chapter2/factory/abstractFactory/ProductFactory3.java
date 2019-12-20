package com.wst.chapter2.factory.abstractFactory;

public class ProductFactory3 implements IProductFactory {
    @Override
    public IProduct createProduct(String productNo) {
        IProduct product = new Product3();//工厂3生产产品对象规则,可以是一类产品的规则.
        System.out.println("create product3");
        return product;
    }
}
