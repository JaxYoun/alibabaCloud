package com.yang.alibabaorder.client;

import com.yang.alibabaorder.config.OpenFeignConfig;
import comg.yang.alibabacommon.entity.Id;
import comg.yang.alibabacommon.entity.Video;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "alibaba-video", configuration = OpenFeignConfig.class)
public interface VideoClient {

    /**
     * 注意必须要声明@RequestParam()的value，否则会【启动失败】
     *
     * @param videoId
     * @return
     */
    @GetMapping("/api/v1/video/find_by_video_id")
    Video findByVideoId(@RequestParam("videoId") String videoId);

    /**
     * @param id
     * @return
     */
    @PostMapping("/api/v1/video/find_by_video_id_1")
    Video findByVideoId_1(@RequestBody Id id);

}
