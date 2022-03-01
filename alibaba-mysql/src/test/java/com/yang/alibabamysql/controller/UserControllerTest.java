package com.yang.alibabamysql.controller;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.MarshallingStrategy;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.core.TreeMarshallingStrategy;
import com.thoughtworks.xstream.io.naming.NoNameCoder;
import com.thoughtworks.xstream.io.xml.KXml2Driver;
import com.thoughtworks.xstream.io.xml.TraxSource;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import com.yang.alibabamysql.AlibabaMysqlApplicationTests;
import lombok.Data;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.oxm.support.MarshallingSource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

class UserControllerTest extends AlibabaMysqlApplicationTests {

//    @Resource
//    private XStreamMarshaller xStreamMarshaller;

//    private  final  static XStream xStream = new XStream(new Xpp3Driver(new NoNameCoder()));

    @SneakyThrows
    @Test
    public static void marshal() {
        Man.Son son = new Man.Son();
        son.setId(2L);
        son.setName("ypw");
        ArrayList<Man.Son> sonArrayList = Lists.newArrayList(son);

        Man man = new Man();
        man.setId(1L);
        man.setName("yjx");
        man.setSonList(sonArrayList);

//        XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
//        xStreamMarshaller.setAutodetectAnnotations(true);

        /*XStream xStream = new XStream(new Xpp3Driver(new NoNameCoder()));
        xStream.processAnnotations(new Class[]{Man.class});
        xStream.autodetectAnnotations(true);*/

        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);

        System.out.println(xStream.toXML(man));
    }

    @SneakyThrows
    public static Object unmarshal() {
//        String xml = "<man><id>1</id><name>yjx</name><sonList><son><id>2</id><name>ypw</name></son></sonList></man>";

        String xml = "<man>\n" +
                "  <id>1</id>\n" +
                "  <name>yjx</name>\n" +
                "  <sonList>\n" +
                "    <son>\n" +
                "      <id>2</id>\n" +
                "      <name>ypw</name>\n" +
                "    </son>\n" +
                "  </sonList>\n" +
                "</man>";
        /*XStreamMarshaller xStreamMarshaller = new XStreamMarshaller();
        xStreamMarshaller.setAutodetectAnnotations(true);
        xStreamMarshaller.setStreamDriver(new Xpp3Driver(new NoNameCoder()));
//        xStreamMarshaller.getXStream().allowTypeHierarchy(Man.class);
        return xStreamMarshaller.getXStream().fromXML(xml);*/

//        InputStream inputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
//        return xStreamMarshaller.unmarshal(new TraxSource(xml, xStreamMarshaller.getXStream()));
        /*xStream.processAnnotations(new Class[]{Man.class});
        xStream.autodetectAnnotations(true);
        xStream.toXML()*/

        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);

        return xStream.fromXML(xml);
    }


    public static void main(String[] args) {
//        marshal();
        Object man = unmarshal();
        System.out.println(man);
//        System.out.println(man.getSonList().get(0).getName());
    }

}

