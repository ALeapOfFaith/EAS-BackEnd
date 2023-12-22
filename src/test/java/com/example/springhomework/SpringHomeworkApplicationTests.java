package com.example.springhomework;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringHomeworkApplicationTests {

    // @Autowired
    // private StudentMapper studentMapper;

    @Test
    void contextLoads() {
        // System.out.println(("----- selectAll method test ------"));
        // List<Student> stuList = studentMapper.selectList(null);
        // stuList.forEach(System.out::println);
    }

    // @Test
    // public void testSelect() {
    //     System.out.println(("----- selectAll method test ------"));
    //     List<Student> stuList = studentMapper.selectList(null);
    //     // Assert.isTrue(5 == stuList.size(), "");
    //     stuList.forEach(System.out::println);
    // }
}
