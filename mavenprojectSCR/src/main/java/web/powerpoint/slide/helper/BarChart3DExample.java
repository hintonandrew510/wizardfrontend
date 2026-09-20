/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.helper;

import java.awt.Color;
import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.ChartUtils; // Note: Use ChartUtilities in versions prior to JFreeChart 1.5.x
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class BarChart3DExample {

    public static void main(String[] args) {
        try {
            // 1. Define the dataset
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            // dataset.addValue(Value, RowKey/Series, ColumnKey/Category)
            dataset.addValue(3346, "Gold Medals", "USA");
            dataset.addValue(4426, "Silver Medals", "USA");
            dataset.addValue(4426, "bronse Medals", "USA");
            dataset.addValue(3448, "Gold Medals", "China");
            dataset.addValue(4429, "Gold Medals", "UK");
            dataset.addValue(4422, "Gold Medals", "Russia");
            dataset.addValue(3346, "Gold Medals", "USA");
            dataset.addValue(4422, "Silver Medals", "USA");
            dataset.addValue(2999, "bronse Medals", "USA");
            dataset.addValue(1448, "Gold Medals", "China");
            dataset.addValue(2429, "Gold Medals", "UK");
            dataset.addValue(3422, "Gold Medals", "Russia");

            // 2. Create the 3D Bar Chart
            JFreeChart barChart3D = ChartFactory.createBarChart3D(
                    "Olympic Gold Medals 2", // Chart title
                    "Country", // Category (X-Axis) axis label
                    "Medals", // Value (Y-Axis) axis label
                    dataset, // Dataset
                    PlotOrientation.VERTICAL, // Plot orientation (VERTICAL or HORIZONTAL)
                    true, // Include legend
                    true, // Include tooltips
                    false // Include URLs
            );

            CategoryPlot plot = (CategoryPlot) barChart3D.getPlot();
            // CategoryItemRenderer renderer = plot.getRenderer();
            BarRenderer3D renderer = (BarRenderer3D) plot.getRenderer();

            // Position the label vertically (-90 degrees) just above the top of the bar
            ItemLabelPosition position = new ItemLabelPosition(
                    ItemLabelAnchor.OUTSIDE12, // Anchor point relative to the bar
                    TextAnchor.CENTER_LEFT, // Text alignment relative to the anchor
                    TextAnchor.CENTER_LEFT,
                    -Math.PI / 2.0 // Rotation angle in radians (-90 degrees)
            );

            renderer.setBasePositiveItemLabelPosition(position);

// Set color for series index 0
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesPaint(1, Color.BLUE);
            renderer.setSeriesPaint(2, Color.GREEN);
            // CategoryPlot plot = barChart.getCategoryPlot();
            //BarRenderer3D renderer2 = new BarRenderer3D();
            renderer.setSeriesPaint(0, Color.RED);
            renderer.setSeriesPaint(1, Color.BLUE);
            renderer.setSeriesPaint(2, Color.GREEN);
            renderer.setBaseItemLabelsVisible(true);
            // Enable labels and set generator
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            //CategoryItemRenderer rendererPlot = plot.getRenderer();
// Reduce the margins between categories to give individual columns more width
//plot.getDomainAxis().setCategoryMargin(0.10); // 10% space instead of default 20%

// Ensure the renderer doesn't artificially limit how wide a bar can scale
//renderer.setMaximumBarWidth(0.25); // Maximum width as a percentage of total plot area
            // 3. Define dimensions and export the chart as a JPEG image
            int width = 640;  // Width of the image
            int height = 480; // Height of the image
            File file = new File("OlympicMedals3D.jpeg");

            // If you are using JFreeChart 1.5+, use ChartUtils.
            // For JFreeChart 1.0.x, use ChartUtilities.saveChartAsJPEG(...)
            //ChartUtils.saveChartAsJPEG(file, barChart3D, width, height);
            ChartUtilities.saveChartAsJPEG(file, barChart3D, width, height);

            System.out.println("3D Bar Chart successfully created and saved as OlympicMedals3D.jpeg" + file.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
