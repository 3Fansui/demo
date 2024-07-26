package com.example.demo.service;

import com.example.demo.Mapper.PlayMapper;
import com.example.demo.Mapper.VideoMapper;
import com.example.demo.dto.Play;
import com.example.demo.dto.Video;
import com.example.demo.util.bv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoServer {

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private PlayMapper playMapper;

    public Video find(String bv){
        Video bybv = videoMapper.findBybv(bv);
        if (bybv == null){
            return null;
        }
        List<Play> bybv1 = playMapper.findBybv(bv);
        bybv.setPlayList(bybv1);
        return bybv;
    }

    public String publish(Video video){
        //设置发布时间
        video.setPublishTime(LocalDateTime.now());
        //向video表中插入数据
        videoMapper.insert(video);
        //生成bv号
        int i = videoMapper.lastInsertId();
        String getbv = bv.getbv(i);
        System.out.println(getbv);
        //更新bv号
        videoMapper.updateBv(getbv,i);
        //向play表插入所有视频选集
        for (Play play : video.getPlayList()) {
            playMapper.insert(play,getbv);
        }
        return getbv;
    }
}
