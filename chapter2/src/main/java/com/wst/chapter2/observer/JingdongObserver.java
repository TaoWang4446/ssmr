package com.wst.chapter2.observer;

import java.util.Observable;
import java.util.Observer;

public class JingdongObserver implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        String newProduct = (String) arg;
        System.out.println("发送新产品["+newProduct+"]同步到京东商城.");
    }
}
