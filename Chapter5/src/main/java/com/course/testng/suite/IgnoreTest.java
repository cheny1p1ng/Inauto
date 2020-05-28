package com.course.testng.suite;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2020/5/22.
 */
public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1执行");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行");
    }
}
