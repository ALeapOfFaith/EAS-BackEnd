package com.example.springHomework.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springHomework.entity.Student;
import com.example.springHomework.entity.Professor;
import com.example.springHomework.mapper.StudentMapper;
import com.example.springHomework.mapper.ProfessorMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    // @Autowired
    @Resource
    private StudentMapper studentMapper;

    @Autowired
    private ProfessorMapper professorMapper;

    public String stuLogin(HttpServletRequest request){
        String sno = request.getParameter("username");
        String psd = request.getParameter("psd");

        Student student = studentMapper.selectOne(new QueryWrapper<Student>().eq("sno",sno));
        if(student.getPsd().equals(psd)){
            return "/student/" + sno;
        }
        return "error";
    }

    public String profLogin(HttpServletRequest request){
        String pno = request.getParameter("username");
        String psd = request.getParameter("psd");

        Professor professor = professorMapper.selectOne(new QueryWrapper<Professor>().eq("pno",pno));
        if(professor.getPsd().equals(psd))
            return "/teacher/" + pno;
        return "error";
    }
}
