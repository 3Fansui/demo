package com.example.demo.service;

import com.example.demo.dto.Play;
import com.example.demo.dto.Video;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

@Service
public class VideoService1 {
    Map<String,Video> map = new HashMap<>();
    @PostConstruct
    public void init(){
        try {
            List<String> data = Files.readAllLines(Path.of("data", "p.csv"));
            for (String line : data) {
                String[] s = line.split(",");
                String[] t = s[7].split("_");
                Video video = new Video(s[0], s[3], LocalDateTime.parse(s[6]), s[4], s[5], Arrays.asList(t), getPlayList(s[0]), s[1], s[2]);
                map.put(s[0],video);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Video find(String bv){
        return map.get(bv);
    }

    private static List<Play> getPlayList(String bv) throws IOException {
        List<String> vdata = Files.readAllLines(Path.of("data", "V_" + bv + ".csv"));
        List<Play> list = new ArrayList<>();
        for (String vline : vdata) {
            String[] ss = vline.split(",");
            list.add(new Play(ss[0],ss[1], LocalTime.parse(ss[3]),ss[2]));
        }
        return list;
    }
}
