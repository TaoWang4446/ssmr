package com.wst.chapter2.observer;

public class TestObserver {
    public static void main(String[] args) {
        ProductList observable = ProductList.getInstance();
        TaobaoObserver taobaoObserver = new TaobaoObserver();
        JingdongObserver jingdongObserver = new JingdongObserver();

        observable.addObserver(jingdongObserver);//被观察者注册到观察者
        observable.addObserver(taobaoObserver);

        observable.addProduct("新增产品1");
    }
}
