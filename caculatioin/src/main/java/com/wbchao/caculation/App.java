package com.wbchao.caculation;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class App {

    public static void main(String[] args) {
        int lineNumber = 5000;
        if (args.length != 0) {
            lineNumber = Integer.parseInt(args[0]);
        }

        ExecutorService pool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            Calculator c = new Calculator(lineNumber, 10);
            pool.submit(c);
        }

        pool.shutdown();
        try {
            boolean loop = true;
            do {
                loop = !pool.awaitTermination(2, TimeUnit.SECONDS);
            } while (loop);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished...");
        System.out.println(Report.getInstance()
                                 .getResult());
        Report.getInstance().generateChart();
    }
}
