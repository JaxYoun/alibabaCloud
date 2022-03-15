package com.yang.alibabamysql.controller;

import com.alibaba.compileflow.engine.ProcessEngine;
import com.alibaba.compileflow.engine.ProcessEngineFactory;
import com.google.common.collect.Maps;
import com.yang.alibabamysql.AlibabaMysqlApplicationTests;
import org.junit.Test;

import java.util.HashMap;


public class CompliedFlowTest extends AlibabaMysqlApplicationTests {

    @Test
    public void go(String[] args) {
        HashMap<String, Double> map = Maps.newHashMap();
        map.put("input", 2D);
//        map.put("", );
        ProcessEngine processEngine = ProcessEngineFactory.getProcessEngine();
        processEngine.load("bpm.my");
        processEngine.execute("bpm.my", map);
    }

}
