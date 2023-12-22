package com.example.springHomework.service;

import com.example.springHomework.entity.SC;
import com.example.springHomework.mapper.StudentCourseMapper;
import com.example.springHomework.entity.CourseProfVo;
import com.example.springHomework.mapper.CourseMapper;
import com.example.springHomework.mapper.SCMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SCService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Autowired
    private SCMapper scMapper;

    @Autowired
    private CourseMapper courseMapper;

    // @Autowired
    // private CourseMapper courseMapper;

    public List<CourseProfVo> checkCourse(HttpServletRequest request){
        //学生查看自己的已选的课程和成绩
        String sno = request.getParameter("username");
        // return studentCourseMapper.checkCourse(sno);
        List<CourseProfVo> list = studentCourseMapper.checkCourse(sno);
        // System.out.println("this is checkCourse:");
        // System.out.println(list);
        return list;
        // return scMapper.checkCourse(sno);
    }

    public List<CourseProfVo> checkAvailableCourses(HttpServletRequest request){
        //学生查看所有可选的课程（不包括已选的课）
        String sno = request.getParameter("username");
        return courseMapper.selectAvailableCourses(sno);
        // List<Course> list = courseMapper.selectList(null);
        // return list;
    }

    public List<CourseProfVo> selectCourse(HttpServletRequest request){
        // 学生选课
        String sno = request.getParameter("username");
        String cno = request.getParameter("cno");

        SC sc = new SC();
        sc.setSno(sno);
        sc.setCno(cno);
        sc.setScore(-1);
        scMapper.insert(sc);

        return studentCourseMapper.checkCourse(sno);
    }

    public List<CourseProfVo> deleteCourse(HttpServletRequest request){
        // 学生删除选课
        String sno = request.getParameter("username");
        String cno = request.getParameter("cno");

        HashMap<String,Object> hm = new HashMap<>();
        hm.put("sno",sno);
        hm.put("cno",cno);
        scMapper.deleteByMap(hm);

        return studentCourseMapper.checkCourse(sno);
    }
}
