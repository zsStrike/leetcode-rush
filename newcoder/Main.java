package newcoder;

import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    // 8 + 4 * (3 + 4 * 5)
    // 8 4 23
    // + *  
    public static void main(String[] args) throws FileNotFoundException {
        List<Integer> list = new LinkedList<>(Arrays.asList(1, 3, 4, 5, 6));
        int sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        String str = list.stream().map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
        System.out.println(str);
    }
}

