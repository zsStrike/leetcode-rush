package newcoder;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    // 8 + 4 * (3 + 4 * 5)
    // 8 4 23
    // + *  
    static HashMap<Integer, Boolean> memo = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(System.in);
        Scanner in = new Scanner(new File(args[0]));
        StringJoiner sj = new StringJoiner(",");
        String[] strs = new String[] {"hello", "world", "hi", "world"};
        Arrays.stream(strs).forEach(a -> sj.add(a));
        System.out.println(sj.toString());
        // String.join(',', Arrays.asList(strs));
        // String.join(",", Arrays.stream(strs).collect(Collectors.toList()));
        // String.join(",", strs);
        String str = "18*(1+1)";
        boolean isAllDigit = "458956".chars().allMatch(a -> Character.isDigit(a));
        System.out.println(isAllDigit);
        System.out.println(String.format("%09s", "hello"));
        int l = str.indexOf("(");
        int r = str.indexOf(")");
        System.out.println(str.substring(0, l) + " " + str.substring(l + 1, r) + " " + str.substring(r + 1));
    }
}

