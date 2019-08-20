package com.wbchao.caculation;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Calculator implements Runnable {

    public static Random r = new Random();

    private int lineNumber = 5000;
    private int loopNumber = 0;

    public Calculator() {
    }

    public Calculator(int lineNumber, int loopNumber) {
        this.lineNumber = lineNumber;
        this.loopNumber = loopNumber;
    }

    public static Map<String, Double> rateTable = new ConcurrentHashMap<>();


    public static NumberStatus parseLine(String str) {
        String[] arr = str.trim()
                          .split(" ");
        NumberStatus result = getNumberStatus(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (!result.equals(getNumberStatus(arr[i]))) {
                return null;
            }
        }
        return result;
    }

    public static NumberStatus getNumberStatus(String str) {

        return Integer.parseInt(str) % 2 == 0 ? NumberStatus.EVEN : NumberStatus.ODD;
    }

    public static String generateLine(int column, int limit) {
        String result = "";
        for (int i = 0; i < column; i++) {
            result += r.nextInt(limit) + " ";
        }
        return result.trim();
    }

    public String generateText(String filename) {
        String result = "";
        File writeName = new File(filename);
        try {
            writeName.createNewFile();

            try (FileWriter writer = new FileWriter(writeName); BufferedWriter out = new BufferedWriter(writer)) {
                for (int i = 0; i < lineNumber; i++) {
                    String line = generateLine(3, 100) + "\r\n";
                    result += line;
                    out.write(line);
                }
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static double getEvenOddRate(String content) {
        int evenCount = 0;
        int oddCount = 0;
        for (String line : content.split("\n")) {
            if (NumberStatus.EVEN.equals(parseLine(line))) {
                evenCount++;
            } else if (NumberStatus.ODD.equals(parseLine(line))) {
                oddCount++;
            }
        }
        if (oddCount == 0) {
            return 0.0;
        } else {
            double rate = (double) evenCount / (double) oddCount;
            System.out.println(rate + "");
            return rate;
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < loopNumber; i++) {
            int index = Report.getInstance()
                              .getCount();
            String content = generateText(index + ".txt");
            Report.getInstance()
                  .addResult(index, getEvenOddRate(content));
        }

    }
}

