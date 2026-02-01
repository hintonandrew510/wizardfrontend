/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.jfree;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.util.TableOrder;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

// Create a 3D Multiple Pie Chart using JFreeChart
public class MultiplePieChart3DExample extends JFrame {

    public MultiplePieChart3DExample(String title) {
        super(title);
        // Create dataset
        CategoryDataset dataset = createDataset();
        // Create chart
        JFreeChart chart = ChartFactory.createMultiplePieChart3D(
            "Multiple 3D Pie Chart", // Chart title
            dataset,                 // Dataset
            TableOrder.BY_COLUMN,    // Data extraction order
            true,                    // Include legend
            true,                    // Tooltips
            false                    // URLs
        );
        // Create panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));
        setContentPane(chartPanel);
    }

    private CategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // RowKey, ColumnKey, Value
        dataset.addValue(10.0, "Region 1", "Product A");
        dataset.addValue(20.0, "Region 1", "Product B");
        dataset.addValue(30.0, "Region 1", "Product C");
        dataset.addValue(15.0, "Region 2", "Product A");
        dataset.addValue(25.0, "Region 2", "Product B");
        dataset.addValue(35.0, "Region 2", "Product C");
        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultiplePieChart3DExample example = new MultiplePieChart3DExample("JFreeChart 3D Multiple Pie Example");
            example.setSize(800, 600);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}
