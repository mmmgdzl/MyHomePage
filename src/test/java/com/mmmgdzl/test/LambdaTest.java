package com.mmmgdzl.test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    @Test
    public void fun1() {

        //Java 8��ʽ��
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }

    @Test
    public void fun2() {
        // ʹ��lambda���ʽ
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + .12*cost).forEach(System.out::println);
    }

    @Test
    public void fun3() {
        // �·�����
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }
    @Test
    public void fun4() {
        // Java 8֮��
        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

// ʹ��Java 8�ķ������ø����㣬����������::˫ð�Ų�������ʾ��
// ��������C++����������������
        features.forEach(System.out::println);
    }

}
