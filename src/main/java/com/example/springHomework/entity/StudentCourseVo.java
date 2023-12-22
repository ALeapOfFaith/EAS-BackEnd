package com.example.springHomework.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class StudentCourseVo {

    @Getter
    @Setter
    public String cno;

    @Getter
    @Setter
    public String cname;

    @Getter
    @Setter
    private float credit;

    @Getter
    @Setter
    private String sno;

    @Getter
    @Setter
    private String sname;

    @Getter
    @Setter
    private float score;
}
