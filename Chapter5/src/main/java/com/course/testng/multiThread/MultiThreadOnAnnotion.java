package com.course.testng.multiThread;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2020/5/22.
 */
public class MultiThreadOnAnnotion {

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id : %s%n", Thread.currentThread().getId());
    }
}
