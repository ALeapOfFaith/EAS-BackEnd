package com.example.springHomework.controller;

import com.example.springHomework.entity.CourseProfVo;
import com.example.springHomework.service.SCService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class SCController {

    @Autowired
    private SCService scService;

    @RequestMapping("/checkCourse")
    public List<CourseProfVo> checkCourse(HttpServletRequest request){
        // 学生查看自己的选课列表和成绩
        return scService.checkCourse(request);
    }

    @RequestMapping("/checkAvailableCourses")
    public List<CourseProfVo> checkAvailableCourses(HttpServletRequest request){
        // 学生查看所有的课程
        return scService.checkAvailableCourses(request);
    }

    @RequestMapping("/selectCourse")
    public List<CourseProfVo> selectCourse(HttpServletRequest request){
        // 学生选课
        return scService.selectCourse(request);
    }

    @RequestMapping("/deleteCourse")
    public List<CourseProfVo> deleteCourse(HttpServletRequest request){
        // 学生删除选课
        return scService.deleteCourse(request);
    }
}
