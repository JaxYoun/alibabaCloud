package com.yang.alibabavideo.controller;

import comg.yang.alibabacommon.entity.Id;
import comg.yang.alibabacommon.entity.Video;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @SneakyThrows
    @GetMapping("/find_by_video_id")
    public Video findByVideoId(ServletRequest request, @RequestParam String videoId) {
        TimeUnit.SECONDS.sleep(1);
        return Video
                .builder()
                .id(1L)
                .tittle("天下无贼")
                .date(LocalDate.now())
                .address(request.getLocalAddr() + ":" + request.getLocalPort())
                .build();
    }

    @SneakyThrows
    @PostMapping("/find_by_video_id_1")
    public Video findByVideoId_1(ServletRequest request, @RequestBody Id id) {
        TimeUnit.SECONDS.sleep(1);
        return Video
                .builder()
                .id(id.getId())
                .tittle("天下无贼")
                .date(LocalDate.now())
                .address(request.getLocalAddr() + ":" + request.getLocalPort())
                .build();
    }

}
