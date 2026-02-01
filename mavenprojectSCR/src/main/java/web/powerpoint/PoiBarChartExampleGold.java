/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class PoiBarChartExampleGold {

    public static void main(String[] args) throws IOException {
        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet("BarChart");

            // 1. Create Data in the Sheet
            final int NUM_OF_ROWS = 5;
            final int NUM_OF_COLS = 3;

            // Row 0: Headers
            XSSFRow row = sheet.createRow(0);
            row.createCell(0).setCellValue("Categories");
            row.createCell(1).setCellValue("Series 1");
            row.createCell(2).setCellValue("Series 2");

            // Fill with dummy data
            for (int r = 1; r < NUM_OF_ROWS; r++) {
                row = sheet.createRow(r);
                row.createCell(0).setCellValue("Category " + r);
                row.createCell(1).setCellValue(r * 2);
                row.createCell(2).setCellValue(r * 3);
            }

            // 2. Create Chart
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 4, 0, 10, 20);
            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("Bar Chart Example");
            chart.setTitleOverlay(false);

            // 3. Define Axes
            XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("Categories");
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("Values");
            // Set axis to cross between categories to avoid half-hidden bars
            leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

            // 4. Create Data Source
            XDDFDataSource<String> categories = XDDFDataSourcesFactory.fromStringCellRange(sheet,
                    new CellRangeAddress(1, NUM_OF_ROWS - 1, 0, 0));
            XDDFNumericalDataSource<Double> values1 = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                    new CellRangeAddress(1, NUM_OF_ROWS - 1, 1, 1));
            XDDFNumericalDataSource<Double> values2 = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                    new CellRangeAddress(1, NUM_OF_ROWS - 1, 2, 2));

            // 5. Create Bar Chart Data
            XDDFBarChartData data = (XDDFBarChartData) chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
            data.setBarGrouping(BarGrouping.CLUSTERED);
            data.setVaryColors(false);
            data.setBarDirection(BarDirection.COL);
            // Add Series
            XDDFBarChartData.Series series1 = (XDDFBarChartData.Series) data.addSeries(categories, values1);
            series1.setTitle("Series 1", null);

            XDDFBarChartData.Series series2 = (XDDFBarChartData.Series) data.addSeries(categories, values2);
            series2.setTitle("Series 2", null);

            // Plot
            chart.plot(data);

            // 6. Save File
            try (FileOutputStream fileOut = new FileOutputStream("./PoiBarChart.xlsx")) {
                wb.write(fileOut);
            }
            System.out.println("Chart created successfully: PoiBarChart.xlsx");
        }
    }
}
