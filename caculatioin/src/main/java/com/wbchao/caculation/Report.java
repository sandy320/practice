package com.wbchao.caculation;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

import javax.xml.transform.Result;

public class Report {

    private Map<Integer, Double> result = new ConcurrentSkipListMap<>();

    private volatile Integer count = 0;

    private Report() {

    }

    private static class Inner {

        private static final Report INSTANCE = new Report();
    }

    public static Report getInstance() {
        return Inner.INSTANCE;
    }

    public void addResult(Integer index, Double rate) {
        result.put(index, rate);
    }

    public int getCount() {
        synchronized (count) {
            return ++count;
        }
    }

    public Map<Integer, Double> getResult() {
        return result;
    }

    public void generateChart() {
        CategoryDataset ds = getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D("Even_Odd_Rate", "Sample Id", "Rate", ds, PlotOrientation.VERTICAL, false, false, false);
        CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
        NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
        CategoryAxis domainAxis = categoryplot.getDomainAxis();
        try (FileOutputStream out = new FileOutputStream("result.jpg")){
            ChartUtilities.writeChartAsJPEG(out, 0.5f, chart, 400, 300, null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private CategoryDataset getDataSet() {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        result.entrySet()
              .forEach(entry -> {
                  ds.addValue(entry.getValue(),entry.getKey(),entry.getKey());
              });
        return ds;
    }
}
