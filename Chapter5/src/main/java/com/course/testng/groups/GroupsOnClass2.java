package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2020/5/22.
 */
@Test(groups = "stu")
public class GroupsOnClass2 {
    public void stu1(){
        System.out.println("这是GroupsOnClass222中的stu1运行");
    }

    public void stu2(){
        System.out.println("这是GroupsOnClass222中的stu2运行");
    }
}

