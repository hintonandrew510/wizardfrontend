/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

// Source - https://stackoverflow.com/a
// Posted by Axel Richter
// Retrieved 2026-12-30, License - CC BY-SA 4.0
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.*;
import org.apache.poi.xssf.usermodel.*;

public class PieChart {

    public static void main(String[] args) throws IOException {

        Object[][] data = new Object[][]{
            new Object[]{"Ad", "B1", "C"},
            new Object[]{51d, 10d, 34d}
        };

        try (XSSFWorkbook wb = new XSSFWorkbook()) {
            XSSFSheet sheet = wb.createSheet("piechart");

            // create sheet data
            Row row;
            Cell cell;
            for (int rowIndex = 0; rowIndex < 2; rowIndex++) {
                row = sheet.createRow((short) rowIndex);
                for (int colIndex = 0; colIndex < 3; colIndex++) {
                    cell = row.createCell((short) colIndex);
                    Object cellValue = data[rowIndex][colIndex];
                    if (cellValue instanceof String) {
                        cell.setCellValue((String) cellValue);
                    } else if (cellValue instanceof Double) {
                        cell.setCellValue((Double) cellValue);
                    }
                }
            }

            // create drawing and anchor
            XSSFDrawing drawing = sheet.createDrawingPatriarch();
            XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 4, 0, 15, 15);

            // create chart
            XSSFChart chart = drawing.createChart(anchor);
            chart.setTitleText("stoday ummary");
            chart.setTitleOverlay(false);
            XDDFChartLegend legend = chart.getOrAddLegend();
            legend.setPosition(LegendPosition.TOP);

            XDDFDataSource<String> cat = XDDFDataSourcesFactory.fromStringCellRange(sheet,
                    new CellRangeAddress(0, 0, 0, 2));
            XDDFNumericalDataSource<Double> val = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
                    new CellRangeAddress(1, 1, 0, 2));

            XDDFChartData chartData = chart.createData(ChartTypes.PIE3D, null, null);
            chartData.setVaryColors(true);
            XDDFChartData.Series series = chartData.addSeries(cat, val);
            chart.plot(chartData);

            // add data labels
            if (!chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).isSetDLbls()) {
                chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).addNewDLbls();
            }
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowLegendKey().setVal(false);
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowPercent().setVal(true);
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowLeaderLines().setVal(false);
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowVal().setVal(false);
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowCatName().setVal(false);
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowSerName().setVal(false);
            chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDLbls()
                    .addNewShowBubbleSize().setVal(false);

            // do not auto delete the title; is necessary for showing title in Calc
            if (chart.getCTChart().getAutoTitleDeleted() == null) {
                chart.getCTChart().addNewAutoTitleDeleted();
            }
            chart.getCTChart().getAutoTitleDeleted().setVal(false);

            // data point colors
            byte[][] rgb = new byte[][]{
                new byte[]{127, 127, (byte) 255},
                new byte[]{(byte) 255, 127, 127},
                new byte[]{127, 127, 127}
            };
            for (int p = 0; p < 3; p++) {
                chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).addNewDPt().addNewIdx().setVal(p);
                chart.getCTChart().getPlotArea().getPie3DChartArray(0).getSerArray(0).getDPtArray(p)
                        .addNewSpPr().addNewSolidFill().addNewSrgbClr().setVal(rgb[p]);
            }

            // write the output to a file
            try (FileOutputStream fileOut = new FileOutputStream("./ooxml-pie-chart.xlsx")) {
                wb.write(fileOut);
            }
        }
    }
}
