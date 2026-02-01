/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.service;

import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.stereotype.Service;
import web.powerpoint.entity.BarChartDataEntity;
import web.powerpoint.entity.BarChartEntity;
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

/**
 *
 * @author andrewhinton
 */
@Service
public class BarChartServiceImpl implements BarChartService {

    @Override
    public String createBarChart(BarChartEntity barChartEntity) throws Exception {
        DefaultCategoryDataset dataSet = createDataSet(barChartEntity);
        JFreeChart barChart = ChartFactory.createBarChart(
                barChartEntity.getTopTitle(),
                barChartEntity.getFileName(), "Score",
                dataSet, PlotOrientation.VERTICAL,
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
        File BarChart = new File(barChartEntity.getFileName() + ".jpeg");
        ChartUtils.saveChartAsJPEG(BarChart, barChart, width, height);
        System.out.println("Chart saved to " + BarChart.getAbsolutePath());
        return BarChart.getAbsolutePath();
    }

    private DefaultCategoryDataset createDataSet(BarChartEntity barChartEntity) {
        List<BarChartDataEntity> barChartDataEntityList = barChartEntity.getBarChartDataEntityList();
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (BarChartDataEntity barChartDataEntity : barChartDataEntityList) {
            dataSet.addValue(barChartDataEntity.getDoubleValue(), barChartDataEntity.getRowKey(), barChartDataEntity.getColumnKey());
        }
        return dataSet;
    }

}
