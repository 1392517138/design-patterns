package top.p3wj.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/10/5 11:23 下午
 */
public class Test {
    public static void main(String[] args) {
        int a = 4;
        Runnable r1 = () -> {
            for (int i = 0; i < a; i++) {
                System.out.println(i);
            }
        };
        r1.run();
    }
}
