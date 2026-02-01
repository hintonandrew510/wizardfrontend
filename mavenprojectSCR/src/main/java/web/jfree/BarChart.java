/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.jfree;

/**
 *
 * @author andrewhinton
 */
import java.awt.Color;
import java.io.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;

public class BarChart {

    public static void main(String[] args) throws Exception {
        final String fiat = "FIAT";
        final String audi = "AUDI";
        final String ford = "FORD";
        final String speed = "Speed";
        final String millage = "Millage";
        final String userrating = "User Rating";
        final String safety = "safety";

        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1.0, fiat, speed);
        dataset.addValue(3.0, fiat, userrating);
        dataset.addValue(5.0, fiat, millage);
        dataset.addValue(5.0, fiat, safety);
//dataset.
        dataset.addValue(5.0, audi, speed);
        dataset.addValue(6.0, audi, userrating);
        dataset.addValue(10.0, audi, millage);
        dataset.addValue(4.0, audi, safety);

        dataset.addValue(4.0, ford, speed);
        dataset.addValue(2.0, ford, userrating);
        dataset.addValue(3.0, ford, millage);
        dataset.addValue(6.0, ford, safety);

        JFreeChart barChart = ChartFactory.createBarChart(
                "CAR USAGE STATIStICS",
                "Category", "Score",
                dataset, PlotOrientation.VERTICAL,
                false, false, false);

        CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();

        //renderer.setBaseItemLabelGenerator();
        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        //renderer.setBaseItemLabelsVisible(true);
        renderer.setDefaultItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
                TextAnchor.TOP_CENTER);
        renderer.setDefaultPositiveItemLabelPosition(position);
        
            barChart.setBackgroundPaint(Color.WHITE);
        barChart.getPlot().setBackgroundPaint(Color.WHITE);
        int width = 640;
        /* Width of the image */
        int height = 480;
        /* Height of the image */
        File BarChart = new File("BarChart.jpeg");
        ChartUtils.saveChartAsJPEG(BarChart, barChart, width, height);
        System.out.println("Chart saved to " + BarChart.getAbsolutePath());
    }
}
