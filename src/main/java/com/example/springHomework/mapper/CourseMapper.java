package com.example.springHomework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springHomework.entity.Course;
import com.example.springHomework.entity.CourseProfVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper extends BaseMapper<Course>{

    List<CourseProfVo> selectAvailableCourses(String sno);
}
