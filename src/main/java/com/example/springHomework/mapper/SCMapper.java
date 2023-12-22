package com.example.springHomework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springHomework.entity.SC;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SCMapper extends BaseMapper<SC> {

    void alterScore(String sno,String cno,int score);
}
