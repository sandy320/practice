package com.wbchao.leetcode;

import java.util.Random;

public class GenerateRandomPointInACircle478 {

    double r;
    double x;
    double y;

    public GenerateRandomPointInACircle478(double radius, double x_center, double y_center) {
        r = radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        Random random = new Random();
        double u = random.nextDouble();
        double theta = random.nextDouble() * 2 * Math.PI;
        double R = Math.sqrt(u) * r;
        return new double[]{x + R * Math.cos(theta), y + R * Math.sin(theta)};

    }
}
