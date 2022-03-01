package com.yang.alibabamysql.controller;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.yang.alibabamysql.AlibabaMysqlApplicationTests;
import com.yang.alibabamysql.domain.bo.Man;
import org.springframework.oxm.xstream.XStreamMarshaller;

import java.util.ArrayList;

class UserControllerTest extends AlibabaMysqlApplicationTests {

    private static final XStreamMarshaller xStreamMarshaller;

    static {
        xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setStreamDriver(new Xpp3Driver(new NoNameCoder()));
        xStreamMarshaller.setAnnotatedClasses(Man.class, Man.Son.class);
        xStreamMarshaller.setAutodetectAnnotations(true);
    }

    public static void marshal() {
        Man.Son son = new Man.Son();
        son.setId(2L);
        son.setName("ypw");
        ArrayList<Man.Son> sonArrayList = Lists.newArrayList(son);

        Man man = new Man();
        man.setId(1L);
        man.setName("yjx");
        man.setSonList(sonArrayList);

        System.err.println(xStreamMarshaller.getXStream().toXML(man));
    }

    public static void unmarshal() {
        String xml = "<man><id>1</id><name>yjx</name><sonList><son><id>2</id><name>ypw</name></son></sonList></man>";
        Man man = (Man) xStreamMarshaller.getXStream().fromXML(xml);
        System.err.println(man.getSonList().get(0).getName());
    }

    public static void main(String[] args) {
        marshal();
        System.out.println("=============");
        unmarshal();
    }

}

