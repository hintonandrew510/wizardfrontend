/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

// Source - https://stackoverflow.com/q
// Posted by praavi, modified by community. See post 'Timeline' for change history
// Retrieved 2026-12-30, License - CC BY-SA 4.0

import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.util.Units;
import org.apache.poi.xddf.usermodel.*;
import org.apache.poi.xddf.usermodel.chart.*;

import java.awt.Rectangle;

public class CreatePowerPointXDDFChart {
    
 public static void main(String[] args) throws Exception {
  try (XMLSlideShow slideShow = new XMLSlideShow()) {
   
   // create a new empty slide
   XSLFSlide slide = slideShow.createSlide();
   
   // create chart
   XSLFChart chart = slideShow.createChart();
   chart.setTitleText("Test Chart");
   
   // set axis
   XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
   XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
   leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);
   leftAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

   // define chart data for bar chart
   XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);

   // add chart categories (x-axis data)
   String[] categories = new String[] { "Category 1", "Category 2", "Category 3" };
   String categoryDataRange = chart.formatRange(new org.apache.poi.ss.util.CellRangeAddress(1, categories.length, 0, 0));
   XDDFCategoryDataSource categoryData = XDDFDataSourcesFactory.fromArray(categories, categoryDataRange, 0);

   // add chart values (y-axis data)
   Double[] values = new Double[] { 10.0, 20.0, 15.0 };
   String valuesDataRange = chart.formatRange(new org.apache.poi.ss.util.CellRangeAddress(1, values.length, 1, 1));
   XDDFNumericalDataSource<Double> valueData = XDDFDataSourcesFactory.fromArray(values, valuesDataRange, 1);
   XDDFBarChartData bar = (XDDFBarChartData) data;
   bar.setBarDirection(BarDirection.BAR);

   // add series
   XDDFChartData.Series series = data.addSeries(categoryData, valueData);
   series.setTitle("Series 1", chart.setSheetTitle("Series 1", 1));
   
   // plot chart
   chart.plot(data);

   // set chart dimensions !!Units are EMU (English Metric Units)!!
   Rectangle chartDimensions = new Rectangle(
    100*Units.EMU_PER_POINT, 
    50*Units.EMU_PER_POINT, 
    400*Units.EMU_PER_POINT, 
    400*Units.EMU_PER_POINT);
   // add chart to slide
   slide.addChart(chart, chartDimensions);

   // Write the output to a file
   try (FileOutputStream fileOut = new FileOutputStream("./CreatePowerPointXDDFChart.pptx")) {
    slideShow.write(fileOut);
   }
  }
 }

}
