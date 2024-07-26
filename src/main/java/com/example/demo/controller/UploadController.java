package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Controller
public class UploadController {

    @Value("${video-path}")
    private String videopath;

    @RequestMapping("/upload")
    @ResponseBody
    public Map<String, String> upload(int i, int chunks, MultipartFile data, String url) throws IOException {
        data.transferTo(Path.of(videopath,url + "part" + i));
        System.out.println(i+"/"+chunks+" "+url);
        return Map.of(url,(i * 100 / chunks) + "%");
    }

    @RequestMapping("/finish")
    @ResponseBody
    public void finish(int chunks,String url) throws IOException {
        try(FileOutputStream fl = new FileOutputStream(videopath+url)) {
            for (int i = 1; i <= chunks; i++) {
                Path of = Path.of(videopath, url + "part" + i);
                Files.copy(of,fl);
                of.toFile().delete();
            }
        }
    }

    @RequestMapping("/uploadCover")
    @ResponseBody
    public Map<String,String> uploadCover(MultipartFile data,String cover) throws IOException {
        data.transferTo(Path.of(videopath,cover));
        return Map.of("cover",cover);
    }


}
