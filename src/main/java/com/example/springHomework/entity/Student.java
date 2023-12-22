package com.example.springHomework.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
// @AllArgsConstructor
public class Student {

    @Getter
    @Setter
    // @TableId
    public String sno;

    @Getter
    @Setter
    public String psd;

    @Getter
    @Setter
    public String sname;

    // @Getter
    // @Setter
    // public boolean sex;
}
