package com.example.demo;

import com.example.demo.Mapper.PlayMapper;
import com.example.demo.Mapper.VideoMapper;
import com.example.demo.dto.Play;
import com.example.demo.dto.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    private PlayMapper playMapper;
    @Test
    void contextLoads() {
        List<Play> bybv = playMapper.findBybv("1");
        System.out.println(bybv.size());
    }

}
