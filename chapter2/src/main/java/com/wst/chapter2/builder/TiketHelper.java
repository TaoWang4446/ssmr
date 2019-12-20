package com.wst.chapter2.builder;

/**
 * 首先,创建一个 TiketHelper对象,他是一个配置类,能帮我们一步步完成构建对象.
 */
public class TiketHelper {
    public void buildAdult(String info){
        System.out.println("构建成人票逻辑: "+info);
    }

    public void buildChildrenForSeat(String info){
        System.out.println("构建有座儿童票票逻辑: "+info);
    }

    public void buildChildrenNoSeat(String info){
        System.out.println("构建无座儿童票票逻辑: "+info);
    }

    public void buildElderly(String info){
        System.out.println("构建老年票逻辑: "+info);
    }

    public void buildSoldier(String info){
        System.out.println("构建军人及其家属票逻辑: "+info);
    }

    /**
     * 然后需要一个构建类 TiketBuilder
     */
}
