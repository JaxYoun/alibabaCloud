package com.yang.alibabamysql.domain.bo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.util.List;

@XStreamAlias(value = "man", impl = Man.class)
@Data
public class Man {

    @XStreamAlias("id")
    private Long id;

    @XStreamAlias("name")
    private String name;

    @XStreamAlias("sonList")
    private List<Son> sonList;

    @XStreamAlias("sssson")
    private Son son;

    @XStreamAlias(value = "son", impl = Son.class)
    @Data
    public static class Son {

        @XStreamAlias("id")
        private Long id;

        @XStreamAlias("name")
        private String name;
    }

}
