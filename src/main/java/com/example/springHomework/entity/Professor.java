package com.example.springHomework.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Professor {

    @Getter
    @Setter
    // @TableId
    public String pno;

    @Getter
    @Setter
    public String psd;

    @Getter
    @Setter
    public String pname;

    // @Getter
    // @Setter
    // public boolean sex;
}
