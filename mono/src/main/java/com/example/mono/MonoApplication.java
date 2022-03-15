package com.example.mono;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class MonoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonoApplication.class, args);
    }

}

@RestController
@RequestMapping("/my")
class MyController {

    /**
     * 1：consumes = MediaType.APPLICATION_XML_VALUE 表示接受xml格式的入参，框架会将xml格式的入参转换为bean。
     * 2：produces = MediaType.APPLICATION_XML_VALUE 表示返回xml格式的结果，框架会将返回值bean转换为xml。
     *
     * @param me
     * @return
     */
    @PostMapping(value = "/getMe", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public Me geMe(@RequestBody Me me) {
        return me;
    }

}

@Data
@JacksonXmlRootElement(localName = "YyghInterface")  //本类对应的xml的根节点名称
class Me {

    @JacksonXmlProperty(localName = "yyjsls")  //声明字段在xml中的节点名称
    private String hospitalSettleSerialNo;

    @JacksonXmlProperty(localName = "pay")
    private String amount;

    @JacksonXmlProperty(localName = "zffs")
    private String payChannel;

}