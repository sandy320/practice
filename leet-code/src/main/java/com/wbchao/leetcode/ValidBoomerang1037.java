package com.wbchao.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidBoomerang1037 {

    public static void main(String[] args) {
//        int[][] points = {{0, 0}, {1, 0}, {2, 2}};
//        System.out.println(isBoomerang(points));

        String u = "admin.zh(dd)";
        Pattern pattern = Pattern.compile("(.*)\\((.*)\\)");
        Matcher m = pattern.matcher(u);
        while (m.find()){
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }

    }

    public static boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return (y2 - y1) * (x3 - x1) != (y3 - y1) * (x2 - x1);
    }
}
