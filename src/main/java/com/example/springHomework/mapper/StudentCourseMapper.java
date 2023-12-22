package com.example.springHomework.mapper;

import com.example.springHomework.entity.CourseProfVo;
import com.example.springHomework.entity.StudentCourseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentCourseMapper {

    List<CourseProfVo> checkCourse(String sno);

    List<StudentCourseVo> checkStudentCourse(String pno);
}
