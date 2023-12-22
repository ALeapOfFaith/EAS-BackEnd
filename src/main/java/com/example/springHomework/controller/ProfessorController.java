package com.example.springHomework.controller;

import com.example.springHomework.entity.Course;
import com.example.springHomework.entity.StudentCourseVo;
import com.example.springHomework.service.ProfessorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/professor")
@CrossOrigin
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @RequestMapping("/checkCourse")
    public List<Course> checkCourse(HttpServletRequest request){
        // 教师查看自己开设的课程
        return professorService.checkCourse(request);
    }

    @RequestMapping("/alterCourse")
    public List<Course> alterCourse(HttpServletRequest request){
        // 教师增加课程
        return professorService.alterCourse(request);
    }

    @RequestMapping("/deleteCourse")
    public List<Course> deleteCourse(HttpServletRequest request){
        // 教师删除选课
        return professorService.deleteCourse(request);
    }

    @RequestMapping("/checkStudentCourse")
    public List<StudentCourseVo> checkStudentCourse(HttpServletRequest request){
        // 教师查看选自己课的学生列表
        return professorService.checkStudentCourse(request);
    }

    // @RequestMapping("/addScore")
    // public String addScore(HttpServletRequest request){
    //     // 教师添加学生课程成绩
    //     return professorService.addScore(request);
    // }

    @RequestMapping("/alterScore")
    public List<StudentCourseVo> alterScore(HttpServletRequest request){
        // 教师增加，修改学生课程成绩
        return professorService.alterScore(request);
    }

    @RequestMapping("/deleteScore")
    public List<StudentCourseVo> deleteScore(HttpServletRequest request){
        // 教师删除学生课程成绩
        return professorService.deleteScore(request);
    }

}
