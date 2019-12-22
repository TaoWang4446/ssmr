//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter16.demo;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Set;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalGenericConverter;
import org.springframework.core.convert.converter.GenericConverter.ConvertiblePair;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

final class StringToArrayConverter implements ConditionalGenericConverter {
    private final ConversionService conversionService;//转化服务类
    //构造方法
    public StringToArrayConverter(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    //可接受类型
    public Set<ConvertiblePair> getConvertibleTypes() {
        //确定转换类型
        return Collections.singleton(new ConvertiblePair(String.class, Object[].class));
    }

    //查找是否存在Converter支持转换,如果不使用系统的,那么需要自己注册
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return ConversionUtils.canConvertElements(sourceType, targetType.getElementTypeDescriptor(), this.conversionService);
    }

    @Nullable
    //转换方法
    public Object convert(@Nullable Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        } else {
            String string = (String)source;//数据源
            String[] fields = StringUtils.commaDelimitedListToStringArray(string);//逗号分隔符
            TypeDescriptor targetElementType = targetType.getElementTypeDescriptor();
            Assert.state(targetElementType != null, "No target element type");
            Object target = Array.newInstance(targetElementType.getType(), fields.length);//转换目标

            for(int i = 0; i < fields.length; ++i) {//遍历数组
                String sourceElement = fields[i];
                //使用conversionService做类型转换,要求我们使用一个自定义或者spring core的Converter.
                Object targetElement = this.conversionService.convert(sourceElement.trim(), sourceType, targetElementType);
                Array.set(target, i, targetElement);
            }

            return target;
        }
    }
}
