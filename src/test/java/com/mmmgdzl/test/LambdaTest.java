package com.mmmgdzl.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    @Test
    public void fun1() {

        //Java 8方式：
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }

    @Test
    public void fun2() {
        // 使用lambda表达式
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
    }

    @Test
    public void fun3() {
        // 新方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }
    @Test
    public void fun4() {
        // Java 8之后：
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
// 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }

}
