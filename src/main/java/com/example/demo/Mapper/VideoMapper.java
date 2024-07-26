package com.example.demo.Mapper;

import com.example.demo.dto.Video;
import org.apache.ibatis.annotations.*;

@Mapper
public interface VideoMapper {

    @Select("""
            select bv,
                   type,
                   category,
                   title,
                   cover,
                   introduction,
                   publish_time,
                   tags
            from b.video
            where bv = #{bv}
            """)
    Video findBybv(String bv);

    @Insert("insert into b.video (type, category, title, cover, introduction, publish_time, tags) \n" +
            "values (#{type},#{category},#{title},#{cover},#{introduction},#{publishTime},#{tags})")
    void insert(Video video);

    @Select("select last_insert_id()")
    int lastInsertId();

    @Update("update b.video set bv=#{bv} where id = #{id}")
    void updateBv(@Param("bv") String bv, @Param("id") int id);

}
