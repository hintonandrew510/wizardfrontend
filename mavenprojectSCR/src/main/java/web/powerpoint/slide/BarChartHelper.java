/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Color;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;
import web.page.ChartBuilder;
import web.page.planamedipage.MediaRowWeb;
import web.page.planamedipage.PlanMediaPageModel;
import web.powerpoint.entity.BarChartDataEntity;
import web.powerpoint.entity.BarChartEntity;

/**
 *
 * @author andrewhinton
 */
public class BarChartHelper {

    public static List<BarChartDataEntity> convert(PlanMediaPageModel planMediaPageModel) {
        int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

        List<BarChartDataEntity> barChartDataEntityList = new ArrayList<>();

        final List<MediaRowWeb> mediaRows = (List<MediaRowWeb>) new Gson().fromJson(planMediaPageModel.getMediaRows(),
                new TypeToken<List<MediaRowWeb>>() {
                }.getType());

        for (MediaRowWeb mediaRow : mediaRows) {
            try {
                jan = jan + ChartBuilder.parse(mediaRow.getJan());
                BarChartDataEntity barChartDataEntityJan = BarChartDataEntity.builder()
                        .columnKey("Jan").rowKey("rowkey").doubleValue(jan).build();
                barChartDataEntityList.add(barChartDataEntityJan);
                
                feb = feb + ChartBuilder.parse(mediaRow.getFeb());
                BarChartDataEntity barChartDataEntityFeb = BarChartDataEntity.builder()
                        .columnKey("Feb").rowKey("rowkey").doubleValue(feb).build();
                barChartDataEntityList.add(barChartDataEntityFeb);
                
                mar = mar + ChartBuilder.parse(mediaRow.getMar());
                BarChartDataEntity barChartDataEntityMar = BarChartDataEntity.builder()
                        .columnKey("Mar").rowKey("rowkey").doubleValue(mar).build();
                barChartDataEntityList.add(barChartDataEntityMar);
                
                apr = apr + ChartBuilder.parse(mediaRow.getApr());
                BarChartDataEntity barChartDataEntityApr = BarChartDataEntity.builder()
                        .columnKey("Apr").rowKey("rowkey").doubleValue(apr).build();
                barChartDataEntityList.add(barChartDataEntityApr);
                
                may = may + ChartBuilder.parse(mediaRow.getMay());
                BarChartDataEntity barChartDataEntityMay = BarChartDataEntity.builder()
                        .columnKey("May").rowKey("rowkey").doubleValue(may).build();
                barChartDataEntityList.add(barChartDataEntityMay);
                
                jun = jun + ChartBuilder.parse(mediaRow.getJun());
                BarChartDataEntity barChartDataEntityJun = BarChartDataEntity.builder()
                        .columnKey("June").rowKey("rowkey").doubleValue(jun).build();
                barChartDataEntityList.add(barChartDataEntityJun);
                
                jul = jul + ChartBuilder.parse(mediaRow.getJul());
                BarChartDataEntity barChartDataEntityJul = BarChartDataEntity.builder()
                        .columnKey("Jul").rowKey("rowkey").doubleValue(jul).build();
                barChartDataEntityList.add(barChartDataEntityJul);
                
                aug = aug + ChartBuilder.parse(mediaRow.getAug());
                BarChartDataEntity barChartDataEntityAug = BarChartDataEntity.builder()
                        .columnKey("Aug").rowKey("rowkey").doubleValue(aug).build();
                barChartDataEntityList.add(barChartDataEntityAug);
                
                sep = sep + ChartBuilder.parse(mediaRow.getSep());
                BarChartDataEntity barChartDataEntitySep = BarChartDataEntity.builder()
                        .columnKey("Sep").rowKey("rowkey").doubleValue(sep).build();
                barChartDataEntityList.add(barChartDataEntitySep);
                oct = oct + ChartBuilder.parse(mediaRow.getOct());
                BarChartDataEntity barChartDataEntityOct = BarChartDataEntity.builder()
                        .columnKey("Oct").rowKey("rowkey").doubleValue(oct).build();
                barChartDataEntityList.add(barChartDataEntityOct);
                
                nov = nov + ChartBuilder.parse(mediaRow.getNov());
                BarChartDataEntity barChartDataEntityNov = BarChartDataEntity.builder()
                        .columnKey("Nov").rowKey("rowkey").doubleValue(nov).build();
                barChartDataEntityList.add(barChartDataEntityNov);
                dec = dec + ChartBuilder.parse(mediaRow.getDec());
                BarChartDataEntity barChartDataEntityDec = BarChartDataEntity.builder()
                        .columnKey("Dev").rowKey("rowkey").doubleValue(dec).build();
                barChartDataEntityList.add(barChartDataEntityDec);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return barChartDataEntityList;

    }
    
    
    
    
     public static String createBarChart(BarChartEntity barChartEntity) throws Exception {
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

    private static DefaultCategoryDataset createDataSet(BarChartEntity barChartEntity) {
        List<BarChartDataEntity> barChartDataEntityList = barChartEntity.getBarChartDataEntityList();
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (BarChartDataEntity barChartDataEntity : barChartDataEntityList) {
            dataSet.addValue(barChartDataEntity.getDoubleValue(), barChartDataEntity.getRowKey(), barChartDataEntity.getColumnKey());
        }
        return dataSet;
    }

}
