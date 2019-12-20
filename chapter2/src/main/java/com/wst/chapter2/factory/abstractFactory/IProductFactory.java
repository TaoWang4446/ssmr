package com.wst.chapter2.factory.abstractFactory;

public interface IProductFactory {
    //工厂的具体实现方法
    public IProduct createProduct(String productNo); //是每一个具体工厂 和 抽象工厂 都要去实现的.现在先实现3个工厂类

}
