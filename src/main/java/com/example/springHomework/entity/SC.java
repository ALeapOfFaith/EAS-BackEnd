package com.example.springHomework.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@TableName("sc")
public class SC {

    @Getter
    @Setter
    @MppMultiId
    // @TableId
    public String sno;

    @Getter
    @Setter
    @MppMultiId
    // @TableId
    public String cno;

    @Getter
    @Setter
    public int score;
}
