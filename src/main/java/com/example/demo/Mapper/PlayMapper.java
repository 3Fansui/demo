package com.example.demo.Mapper;

import com.example.demo.dto.Play;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayMapper {

    @Select("select id, title, url, duration " +
            "from b.play " +
            "where bv = #{bv}")
    List<Play> findBybv(String bv);

    @Insert("insert into b.play(id,title,duration,url,bv) values" +
            "(#{p.id},#{p.title},#{p.duration},#{p.url},#{bv}) ")
    void insert(@Param("p") Play play, @Param("bv") String bv);
}
