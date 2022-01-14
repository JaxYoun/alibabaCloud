package com.yang.alibabaorder.controller;

import com.yang.alibabaorder.client.VideoClient;
import comg.yang.alibabacommon.entity.Id;
import comg.yang.alibabacommon.entity.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 0.手动使用RestTemplate发起远程调用
     *
     * @param videoId
     * @return
     */
    @GetMapping("/add")
    public Object add(@RequestParam String videoId) {
        Video video = this.restTemplate.getForObject("http://localhost:8300/api/v1/video/find_by_video_id?videoId=" + videoId, Video.class);
        System.err.println(video);
        return video;
    }

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 1.接入服务注册-发现，但仍使用RestTemplate发起远程调用
     *
     * @param videoId
     * @return
     */
    @GetMapping("/add_1")
    public Object add_1(@RequestParam String videoId) {
        List<ServiceInstance> instanceList = this.discoveryClient.getInstances("alibaba-video");
        //可以在这里实现手动的客户端负载均衡
        ServiceInstance instance = instanceList.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        Video video = this.restTemplate.getForObject("http://" + host + ":" + port + "/api/v1/video/find_by_video_id?videoId=" + videoId, Video.class);
        System.err.println(video);
        return video;
    }

    /**
     * 2.接入服务注册-发现，加入Ribbon做负载均衡，仍使用RestTemplate发起远程调用
     *
     * @param videoId
     * @return
     */
    @GetMapping("/add_2")
    public Object add_2(@RequestParam String videoId) {
        Video video = this.restTemplate.getForObject("http://alibaba-video/api/v1/video/find_by_video_id?videoId=" + videoId, Video.class);
        System.err.println(video);
        return video;
    }

    @Resource
    private VideoClient videoClient;

    /**
     * 3.使用OpenFeign实现声明式接口调用，服务注册-发现，底层Ribbon做负载均衡，仍使用RestTemplate发起远程调用
     *
     * @param videoId
     * @return
     */
    @GetMapping("/add_3")
    public Object add_3(@RequestParam String videoId) {
        Video video = this.videoClient.findByVideoId(videoId);
        System.err.println(video);
        return video;
    }

    /**
     * 3_1.【POST测试】使用OpenFeign实现声明式接口调用，服务注册-发现，底层Ribbon做负载均衡，仍使用RestTemplate发起远程调用
     *
     * @param id
     * @return
     */
    @GetMapping("/add_4")
    public Object add_4(@RequestParam Long id) {
        Video video = this.videoClient.findByVideoId_1(new Id(id));
        System.err.println(video);
        return video;
    }

    @Value("${yang.name}")
    private String name;

    /**
     * 分布式-动态配置
     *
     * @return
     */
    @GetMapping("/getConfig")
    public Object getConfig() {
        return this.name;
    }

}
