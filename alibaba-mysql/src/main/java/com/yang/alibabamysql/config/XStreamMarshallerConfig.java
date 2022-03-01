package com.yang.alibabamysql.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
public class XStreamMarshallerConfig {

    @Bean
    public XStreamMarshaller getXStreamMarshaller() {
        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setAutodetectAnnotations(true);
        return xStreamMarshaller;
    }

}
