package com.wst.chapter2.factory.abstractFactory;

/**
 * 根据产品编号123分别由 工厂 ProductFactory123 来创建的规则 来写 公共的工厂
 */
public class ProductFactory implements IProductFactory{
    @Override
    public IProduct createProduct(String productNo) {
        char ch = productNo.charAt(0);
        System.out.println(ch+"...........>>>>>>>>");
        IProductFactory factory = null;
        if(ch == '1'){
            factory = new ProductFactory1();
        }else if(ch == '2'){
            factory = new ProductFactory2();
        }else if(ch == '3'){
            factory = new ProductFactory3();
        }
        if(factory != null){
            return factory.createProduct(productNo);
        }

        return null;
    }

    public static void main(String[] args) {
        new ProductFactory().createProduct("3132");
    }
}
