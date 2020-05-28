package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2020/5/22.
 */
@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("这是GroupsOnClass333中的teacher1运行");
    }

    public void teacher2(){
        System.out.println("这是GroupsOnClass333中的teacher2运行");
    }
}
