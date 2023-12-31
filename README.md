## 系统使用指南

#### 1.启动项目

- 项目采用前后端分离的形式，文件夹bighomework为前端，springHomework为后端

- 打开bighomework，在终端上输入npm run dev命令运行项目
- 打开springHomework项目，修改application.yml中数据库配置的username和password即可（**不需要修改url**）
- springHomework根目录下的init.sql是数据库初始化文件，在MySQL数据库中导入文件（注意编码格式为UTF-8）后运行

#### 2.测试系统

- 通过右侧地址访问登录页面：localhost:8080/#/login

  初始有三位学生，学工号分别为**S1，S2，S3**，以及三位教师**P1，P2，P3**，他们的**登录密码均为123456**。

- 在登录页点击注册按钮进入注册页面，

  或者通过右侧地址访问注册页面：localhost:8080/#/register

  注册成功后自动登录进入系统。

- 在学生的页面：

  左侧一列显示该学生未选的课，学生可以在这里**选课**；

  右侧一列显示学生已选的课和成绩（-1表示该门课程暂时没有成绩），学生可以在这里**退课**（已有成绩的课程无法退课）。

- 在教师的页面：

  **开设新课程**与**编辑已有课程**，需要手动输入课程id、课程名、课程学分三种信息，**删除已开设的课程**后，对应的学生选课信息也会删除；

  管理学生成绩，**添加成绩**与**修改已有成绩**时需输入学生id、课程、成绩三种信息，**删除成绩**时只需要输入学生id和课程。

