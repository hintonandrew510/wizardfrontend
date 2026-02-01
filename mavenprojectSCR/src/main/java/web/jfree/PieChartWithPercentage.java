/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.jfree;

import java.awt.Color;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import web.page.PieChart;

public class PieChartWithPercentage {

    public static void main(String[] args) {
        List<PieChart> pieChartList = new ArrayList<>();
        PieChart pieChartApple = new PieChart("apple",20);
        PieChart pieChartPear = new PieChart("pear",50);
        //PieChart(String label, int labelValue)
        pieChartList.add(pieChartPear);
        pieChartList.add(pieChartApple);
        // 1. Create a dataset
        PieDataset dataset = createDataset(pieChartList);
//ChartFactory.createMultiplePieChart3D(title, dataset, TableOrder.BY_ROW, true, true, true)
        // 2. Create the chart
        JFreeChart chart = ChartFactory.createPieChart3D(
                "Mobile Sales", // Chart title
                dataset, // Data
                true, // Include legend
                true, // Include tooltips
                false // Exclude URLs
        );

        // 3. Customize the plot to show percentages
        final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( ); 
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
            File pieChart = new File("PieChartWithPercentage.jpeg");
            ChartUtils.saveChartAsJPEG(pieChart, chart, 640, 480);
            System.out.println("Chart saved to " + pieChart.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("Could not write chart: " + e.getMessage());
        }
    }

    /**
     * Creates a sample dataset.
     */
    private static PieDataset createDataset(List<PieChart> pieChartList) {
        
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        for (PieChart pieChart : pieChartList) {
            dataset.setValue(pieChart.getLabel(), pieChart.getLabelValue());
        }
        
        return dataset;
    }
}
