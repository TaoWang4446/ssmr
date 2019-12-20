package com.wst.chapter2.builder;

public class TiketBuilder {
    public static Object builder(TiketHelper helper){//只需要一个配置类的参数,通过它就可以得到所有套票的信息,从而构建套票对象.
        System.out.println("通过TiketBuilder 去构建套票信息");
        return null;
    }

    public static void main(String[] args) {
        TiketHelper helper = new TiketHelper();
        helper.buildAdult("成人票");
        helper.buildChildrenForSeat("有座儿童票");
        helper.buildChildrenNoSeat("无座儿童票");
        helper.buildElderly("老年票");
        helper.buildSoldier("军人票");

        Object ticket = TiketBuilder.builder(helper);

        /**
         * 构建分为若干步骤,一步步构建信息,把一个复杂的对象构建出来.
         */
    }
}
