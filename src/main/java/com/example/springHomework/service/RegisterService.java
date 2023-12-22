package com.example.springHomework.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springHomework.entity.Professor;
import com.example.springHomework.entity.Student;
import com.example.springHomework.mapper.ProfessorMapper;
import com.example.springHomework.mapper.StudentMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    // @Autowired
    @Resource
    private StudentMapper studentMapper;

    @Autowired
    private ProfessorMapper professorMapper;

    public String stuRegister(HttpServletRequest request){
        String sno = request.getParameter("username");
        // String psd = request.getParameter("psd");

        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("sno",sno));
        if(student==null){
            student = new Student();
            student.setSno(sno);
            student.setPsd(request.getParameter("psd"));
            student.setSname(request.getParameter("name"));
            studentMapper.insert(student);
            return "/student/" + sno;
        }else{
            return "error";
        }
        // Student student = new Student();
        // student.setSno(request.getParameter("username"));
        // student.setPsd(request.getParameter("psd"));
        // student.setSname(request.getParameter("name"));
        // studentMapper.insert(student);
        // return "registerSuccess";

    }

    public String profRegister(HttpServletRequest request){
        String pno = request.getParameter("username");
        // String psd = request.getParameter("psd");
        Professor professor = professorMapper.selectOne(new QueryWrapper<Professor>().eq("pno",pno));
        if(professor==null){
            professor = new Professor();
            professor.setPno(pno);
            professor.setPsd(request.getParameter("psd"));
            professor.setPname(request.getParameter("name"));
            professorMapper.insert(professor);
            return "/teacher/" + pno;
        }else{
            return "error";
        }
        // Professor professor = new Professor();


        // Professor professor = professorMapper.selectOne(new QueryWrapper<Professor>().eq("uid",uid));
        // if(professor.getPsd().equals(psd))
        //     return "professor";
        // return "error";
        // return "teacher";
    }
}
