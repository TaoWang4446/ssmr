//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.ssm.chapter16.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.util.Assert;

/**
 * 使用 MappingJackson2CborHttpMessageConverter 之前需要配置,注册它
 *
 */
public class MappingJackson2CborHttpMessageConverter extends AbstractJackson2HttpMessageConverter {
    public MappingJackson2CborHttpMessageConverter() {
        this(Jackson2ObjectMapperBuilder.cbor().build());
    }

    public MappingJackson2CborHttpMessageConverter(ObjectMapper objectMapper) {
        super(objectMapper, MediaType.APPLICATION_CBOR);
        Assert.isInstanceOf(CBORFactory.class, objectMapper.getFactory(), "CBORFactory required");
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        Assert.isInstanceOf(CBORFactory.class, objectMapper.getFactory(), "CBORFactory required");
        super.setObjectMapper(objectMapper);
    }
}
