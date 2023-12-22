package com.example.springHomework.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springHomework.entity.Course;
import com.example.springHomework.entity.SC;
import com.example.springHomework.entity.StudentCourseVo;
import com.example.springHomework.mapper.CourseMapper;
import com.example.springHomework.mapper.SCMapper;
import com.example.springHomework.mapper.StudentCourseMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    @Autowired
    private SCMapper scMapper;

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> checkCourse(HttpServletRequest request){
        // 教师查看自己开设的课程
        String pno = request.getParameter("username");
        return courseMapper.selectList(new QueryWrapper<Course>().eq("pno",pno));
        // List<Course> list = courseMapper.selectList(new QueryWrapper<Course>().eq("pno",pno));
        // return list;
    }

    public List<Course> alterCourse(HttpServletRequest request){
        // 教师增加或编辑课程
        String cno = request.getParameter("cno");
        String cname = request.getParameter("cname");
        String pno = request.getParameter("username");
        float credit = Float.parseFloat(request.getParameter("credit"));

        Course course = courseMapper.selectOne(new QueryWrapper<Course>().eq("cno",cno));
        if(course==null){
            //course为空，说明不存在，应该新建课程
            course = new Course();
            course.setCno(cno);
            course.setCname(cname);
            course.setPno(pno);
            course.setCredit(credit);
            courseMapper.insert(course);
        }else{
            // course不为空，说明已有课程，应该修改课程
            course.setCno(cno);
            course.setCname(cname);
            course.setPno(pno);
            course.setCredit(credit);
            courseMapper.updateById(course);
        }

        return courseMapper.selectList(new QueryWrapper<Course>().eq("pno",pno));
    }

    public List<Course> deleteCourse(HttpServletRequest request){
    // public List<Course> deleteCourse(HttpServletRequest request){
        // 教师删除选课
        String pno = request.getParameter("username");
        String cno = request.getParameter("cno");

        courseMapper.delete(new QueryWrapper<Course>().eq("cno",cno));

        // return "success";
        return courseMapper.selectList(new QueryWrapper<Course>().eq("pno",pno));
    }

    public List<StudentCourseVo> checkStudentCourse(HttpServletRequest request){
        // 教师查看选自己课的学生列表
        String pno = request.getParameter("username");

        return studentCourseMapper.checkStudentCourse(pno);

        // return professorService.checkStudentCourse(request);
    }

    public List<StudentCourseVo> alterScore(HttpServletRequest request){
        // 教师添加，修改学生课程成绩
        String sno = request.getParameter("sno");
        String cno = request.getParameter("cno");
        String s = request.getParameter("score");
        String pno = request.getParameter("username");
        int score;
        if(!s.equals("")){
            score = Integer.parseInt(s);

        }else{
            score = -1;

        }
        scMapper.alterScore(sno,cno,score);

        // SC sc = new SC();
        // sc.setSno(sno);
        // sc.setCno(cno);
        // if(s!=null)
        //     sc.setScore(Integer.parseInt(s));
        // HashMap<String,Object> hm = new HashMap<>();
        // hm.put("sno",sno);
        // hm.put("cno",cno);
        // scMapper.update(sc,new QueryWrapper<SC>().allEq(hm));

        // return "success";
        return studentCourseMapper.checkStudentCourse(pno);
    }

    public List<StudentCourseVo> deleteScore(HttpServletRequest request){
        // 教师删除学生课程成绩
        String sno = request.getParameter("sno");
        String cno = request.getParameter("cno");
        String pno = request.getParameter("username");

        SC sc = new SC();
        sc.setSno(sno);
        sc.setCno(cno);
        sc.setScore(-1);

        HashMap<String,Object> hm = new HashMap<>();
        hm.put("sno",sno);
        hm.put("cno",cno);
        scMapper.update(sc,new QueryWrapper<SC>().allEq(hm));
        // return "success";
        return studentCourseMapper.checkStudentCourse(pno);
    }
}
