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
    static HashMap<Integer, Boolean> memo = new HashMap<>();
    public static void main(String[] args) throws FileNotFoundException {
        // Scanner in = new Scanner(System.in);
        char[] cs = "This".toCharArray();
        Arrays.sort(cs);
        System.out.println(Arrays.toString(cs));
        System.out.println(Integer.parseInt("0123")); 
        TreeSet<Character> set = new TreeSet<>(Arrays.asList('b', 'c', 'a'));
        System.out.println(set.stream().map(a -> "" + a).collect(Collectors.joining("")));
        System.out.println(new LinkedList<String>(){{add("1"); add("2");}}.stream().collect(Collectors.joining(",")));
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

