//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter16.demo;

import java.util.Set;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public interface GenericConverter {
    //返回可接受的转换类型
    @Nullable
    Set<GenericConverter.ConvertiblePair> getConvertibleTypes();
    //转换方法
    @Nullable
    Object convert(@Nullable Object var1, TypeDescriptor var2, TypeDescriptor var3);

    //可转换匹配类
    public static final class ConvertiblePair {
        private final Class<?> sourceType;  //源类型
        private final Class<?> targetType;//目标类型

        public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
            Assert.notNull(sourceType, "Source type must not be null");
            Assert.notNull(targetType, "Target type must not be null");
            this.sourceType = sourceType;
            this.targetType = targetType;
        }

        public Class<?> getSourceType() {
            return this.sourceType;
        }

        public Class<?> getTargetType() {
            return this.targetType;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            } else if (other != null && other.getClass() == GenericConverter.ConvertiblePair.class) {
                GenericConverter.ConvertiblePair otherPair = (GenericConverter.ConvertiblePair)other;
                return this.sourceType == otherPair.sourceType && this.targetType == otherPair.targetType;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.sourceType.hashCode() * 31 + this.targetType.hashCode();
        }

        public String toString() {
            return this.sourceType.getName() + " -> " + this.targetType.getName();
        }
    }
}
