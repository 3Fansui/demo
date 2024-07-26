package com.example.demo.controller;


import com.example.demo.dto.Video;
import com.example.demo.service.VideoServer;
import com.example.demo.service.VideoService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;

@Controller
public class VideoController {

    @Autowired
    VideoService1 videoService1;

    @Autowired
    VideoServer videoServer;

    @RequestMapping("/video/{bv}")
    @ResponseBody
    public Video t(@PathVariable String bv){
            return videoServer.find(bv);
    }

    @RequestMapping("/publish")
    @ResponseBody
    public Map<String,String> publish(@RequestBody Video video){
        String publish = videoServer.publish(video);
        System.out.println(publish);
        return Map.of("bv",publish);
    }

}
