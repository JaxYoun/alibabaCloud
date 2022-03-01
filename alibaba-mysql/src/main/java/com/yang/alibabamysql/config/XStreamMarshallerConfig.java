package com.yang.alibabamysql.config;

import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.yang.alibabamysql.domain.bo.Man;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
public class XStreamMarshallerConfig {

    @Bean
    public XStreamMarshaller getXStreamMarshaller() {
        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setStreamDriver(new Xpp3Driver(new NoNameCoder()));
        xStreamMarshaller.setAnnotatedClasses(Man.class, Man.Son.class);
        xStreamMarshaller.setAutodetectAnnotations(true);
        return xStreamMarshaller;
    }

}
