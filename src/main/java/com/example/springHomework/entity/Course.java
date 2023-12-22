package com.example.springHomework.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Course {

    @Getter
    @Setter
    @TableId
    public String cno;

    @Getter
    @Setter
    public String cname;

    @Getter
    @Setter
    public String pno;

    @Getter
    @Setter
    public float credit;
}
