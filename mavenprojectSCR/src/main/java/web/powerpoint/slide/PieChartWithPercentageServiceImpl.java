/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.springframework.stereotype.Service;
import web.powerpoint.entity.PieEntity;

/**
 *
 * @author andrewhinton
 */
public class PieChartWithPercentageServiceImpl implements PieChartWithPercentageService {

    @Override
    public String createPieChart(PieEntity pieEntity) {
    PieDataset dataset = createDataset(pieEntity.getPieChartList());
        JFreeChart chart = ChartFactory.createPieChart3D(
                pieEntity.getTitle(), // Chart title
                dataset, // Data
                true, // Include legend
                true, // Include tooltips
                false // Exclude URLs
        );
        // 3. Customize the plot to show percentages
        final PiePlot3D plot = (PiePlot3D) chart.getPlot();
        //PiePlot plot = (PiePlot) chart.getPlot();

// 2. Set the background color for the overall chart area
        chart.setBackgroundPaint(Color.WHITE);
        plot.setBackgroundPaint(Color.WHITE);

        // Define the label format: {0} = key, {1} = value, {2} = percentage
        String labelFormat = "{0} = {2}";

        // Create the label generator with specific number and percentage formats
        PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                labelFormat,
                NumberFormat.getNumberInstance(),
                new DecimalFormat("0.00%") // Formats the percentage to two decimal places
        );

        plot.setLabelGenerator(generator);

        // Optional: Set simple labels for better positioning
        plot.setSimpleLabels(true);
        
        // 4. Save the chart as an image file
        try {
            File pieChart = new File(pieEntity.getFileName()+".jpeg");
            ChartUtils.saveChartAsJPEG(pieChart, chart, 640, 480);
            System.out.println("Chart saved to " + pieChart.getAbsolutePath());
            return pieChart.getAbsolutePath();
        } catch (Exception e) {
            System.err.println("Could not write chart: " + e.getMessage());
            return null;
        }
    }

    private PieDataset createDataset(List<web.page.PieChart> pieChartList) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (web.page.PieChart pieChart : pieChartList) {
            dataset.setValue(pieChart.getLabel(), pieChart.getLabelValue());
        }

        return dataset;
    }

}
