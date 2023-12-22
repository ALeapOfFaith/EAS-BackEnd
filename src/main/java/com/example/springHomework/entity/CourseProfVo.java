package com.example.springHomework.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CourseProfVo {

    @Getter
    @Setter
    public String cno;

    @Getter
    @Setter
    public String cname;

    @Getter
    @Setter
    private String pname;

    @Getter
    @Setter
    private float credit;

    @Getter
    @Setter
    private float score;
}
