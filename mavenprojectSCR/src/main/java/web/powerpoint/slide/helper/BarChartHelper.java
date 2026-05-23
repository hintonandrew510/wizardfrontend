/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide.helper;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import web.powerpoint.slide.service.*;
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
import java.util.ArrayList;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import web.page.ChartBuilder;
import web.page.planamedipage.MediaChart;
import web.page.planamedipage.MediaRowWeb;
import web.page.planamedipage.PlanMediaPageModel;

//import org.jfree.chart.renderer.category.BarRenderer3D;
/**
 *
 * @author andrewhinton
 */
@Service
public class BarChartHelper {

    public static String createBarChart(BarChartEntity barChartEntity) throws Exception {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        /// dataSet.addValue(barChartDataEntity.getDoubleValue(), barChartDataEntity.getRowKey(), barChartDataEntity.getColumnKey())
        for (BarChartDataEntity barChartDataEntity : barChartEntity.getBarChartDataEntityList()) {
            dataset.addValue(barChartDataEntity.getDoubleValue(), barChartDataEntity.getRowKey(), barChartDataEntity.getColumnKey());
        }

        JFreeChart barChart = ChartFactory.createBarChart3D(
                "",
                "Months",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        int width = 640;
        /* Width of the image */
        int height = 480;
        /* Height of the image */

         CategoryItemRenderer renderer = ((CategoryPlot) barChart.getPlot()).getRenderer();

        //renderer.setBaseItemLabelGenerator();
//        renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
//        //renderer.setBaseItemLabelsVisible(true);
//        renderer.setDefaultItemLabelsVisible(true);
//        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
//                TextAnchor.TOP_CENTER);
        //renderer.setDefaultPositiveItemLabelPosition(position);
        barChart.setBackgroundPaint(Color.WHITE);
        barChart.getPlot().setBackgroundPaint(Color.WHITE);
        File barChart3D = new File(barChartEntity.getFileName() + ".png");
        // ChartUtils..saveChartAsJPEG( barChart3D, barChart, width, height);
        ChartUtilities.saveChartAsJPEG(barChart3D, barChart, width, height);
        //  ChartUtils.saveChartAsPNG(barChart3D, barChart, width, height);
        System.out.println("Path " + barChart3D.getAbsolutePath());
        return barChart3D.getAbsolutePath();
    }

    public static List<BarChartDataEntity> convert(PlanMediaPageModel planMediaPageModel) {
        int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0, dec = 0;

        List<BarChartDataEntity> barChartDataEntityList = new ArrayList<>();

        final List<MediaRowWeb> mediaRows = (List<MediaRowWeb>) new Gson().fromJson(planMediaPageModel.getMediaRows(),
                new TypeToken<List<MediaRowWeb>>() {
                }.getType());

        for (MediaRowWeb mediaRow : mediaRows) {
            try {
                MediaChart mediaChart = new MediaChart("Spike Months", "Spike Months", "Spike Months", "Spike Months", "Spike Months", "Spike Months", "Spike Months", "Spike Months",
                        "Spike Months", "Spike Months", "Spike Months", "Spike Months");
                if (planMediaPageModel.getJanType().equalsIgnoreCase("Base")) {
                    mediaChart.setJanColor("Brand Equity Months");
                }
                if (planMediaPageModel.getFebType().equalsIgnoreCase("Base")) {
                    mediaChart.setFebColor("Brand Equity Months");
                }
                if (planMediaPageModel.getMarType().equalsIgnoreCase("Base")) {
                    mediaChart.setMarColor("Brand Equity Months");
                }
                if (planMediaPageModel.getAprType().equalsIgnoreCase("Base")) {
                    mediaChart.setAprColor("Brand Equity Months");
                }
                if (planMediaPageModel.getMayType().equalsIgnoreCase("Base")) {
                    mediaChart.setMayColor("Brand Equity Months");
                }
                if (planMediaPageModel.getJunType().equalsIgnoreCase("Base")) {
                    mediaChart.setJunColor("Brand Equity Months");
                }
                if (planMediaPageModel.getJulType().equalsIgnoreCase("Base")) {
                    mediaChart.setJulColor("Brand Equity Months");
                }
                if (planMediaPageModel.getAugType().equalsIgnoreCase("Base")) {
                    mediaChart.setAugColor("Brand Equity Months");
                }
                if (planMediaPageModel.getSeptType().equalsIgnoreCase("Base")) {
                    mediaChart.setSepColor("Brand Equity Months");
                }
                if (planMediaPageModel.getOctType().equalsIgnoreCase("Base")) {
                    mediaChart.setOctColor("Brand Equity Months");
                }
                if (planMediaPageModel.getNovType().equalsIgnoreCase("Base")) {
                    mediaChart.setNovColor("Brand Equity Months");
                }
                if (planMediaPageModel.getDecType().equalsIgnoreCase("Base")) {
                    mediaChart.setDecColor("Brand Equity Months");
                }

                if (planMediaPageModel.getJanType().equalsIgnoreCase("Slow")) {
                    mediaChart.setJanColor("Slow Months");
                }
                if (planMediaPageModel.getFebType().equalsIgnoreCase("Slow")) {
                    mediaChart.setFebColor("Slow Months");
                }
                if (planMediaPageModel.getMarType().equalsIgnoreCase("Slow")) {
                    mediaChart.setMarColor("Slow Months");
                }
                if (planMediaPageModel.getAprType().equalsIgnoreCase("Slow")) {
                    mediaChart.setAprColor("Slow Months");
                }
                if (planMediaPageModel.getMayType().equalsIgnoreCase("Slow")) {
                    mediaChart.setMayColor("red");
                }
                if (planMediaPageModel.getJunType().equalsIgnoreCase("Slow")) {
                    mediaChart.setJunColor("Slow Months");
                }
                if (planMediaPageModel.getJulType().equalsIgnoreCase("Slow")) {
                    mediaChart.setJulColor("Slow Months");
                }
                if (planMediaPageModel.getAugType().equalsIgnoreCase("Slow")) {
                    mediaChart.setAugColor("Slow Months");
                }
                if (planMediaPageModel.getSeptType().equalsIgnoreCase("Slow")) {
                    mediaChart.setSepColor("Slow Months");
                }
                if (planMediaPageModel.getOctType().equalsIgnoreCase("Slow")) {
                    mediaChart.setOctColor("Slow Months");
                }
                if (planMediaPageModel.getNovType().equalsIgnoreCase("Slow")) {
                    mediaChart.setNovColor("Slow Months");
                }
                if (planMediaPageModel.getDecType().equalsIgnoreCase("Slow")) {
                    mediaChart.setDecColor("Slow Months");
                }

                jan = jan + ChartBuilder.parse(mediaRow.getJan());
                BarChartDataEntity barChartDataEntityJan = BarChartDataEntity.builder()
                        .columnKey("Jan").rowKey(mediaChart.getJanColor()).doubleValue(jan).build();
                barChartDataEntityList.add(barChartDataEntityJan);

                feb = feb + ChartBuilder.parse(mediaRow.getFeb());
                BarChartDataEntity barChartDataEntityFeb = BarChartDataEntity.builder()
                        .columnKey("Feb").rowKey(mediaChart.getFebColor()).doubleValue(feb).build();
                barChartDataEntityList.add(barChartDataEntityFeb);

                mar = mar + ChartBuilder.parse(mediaRow.getMar());
                BarChartDataEntity barChartDataEntityMar = BarChartDataEntity.builder()
                        .columnKey("Mar").rowKey(mediaChart.getMarColor()).doubleValue(mar).build();
                barChartDataEntityList.add(barChartDataEntityMar);

                apr = apr + ChartBuilder.parse(mediaRow.getApr());
                BarChartDataEntity barChartDataEntityApr = BarChartDataEntity.builder()
                        .columnKey("Apr").rowKey(mediaChart.getAugColor()).doubleValue(apr).build();
                barChartDataEntityList.add(barChartDataEntityApr);

                may = may + ChartBuilder.parse(mediaRow.getMay());
                BarChartDataEntity barChartDataEntityMay = BarChartDataEntity.builder()
                        .columnKey("May").rowKey(mediaChart.getMayColor()).doubleValue(may).build();
                barChartDataEntityList.add(barChartDataEntityMay);

                jun = jun + ChartBuilder.parse(mediaRow.getJun());
                BarChartDataEntity barChartDataEntityJun = BarChartDataEntity.builder()
                        .columnKey("June").rowKey(mediaChart.getJunColor()).doubleValue(jun).build();
                barChartDataEntityList.add(barChartDataEntityJun);

                jul = jul + ChartBuilder.parse(mediaRow.getJul());
                BarChartDataEntity barChartDataEntityJul = BarChartDataEntity.builder()
                        .columnKey("Jul").rowKey(mediaChart.getJulColor()).doubleValue(jul).build();
                barChartDataEntityList.add(barChartDataEntityJul);

                aug = aug + ChartBuilder.parse(mediaRow.getAug());
                BarChartDataEntity barChartDataEntityAug = BarChartDataEntity.builder()
                        .columnKey("Aug").rowKey(mediaChart.getAugColor()).doubleValue(aug).build();
                barChartDataEntityList.add(barChartDataEntityAug);

                sep = sep + ChartBuilder.parse(mediaRow.getSep());
                BarChartDataEntity barChartDataEntitySep = BarChartDataEntity.builder()
                        .columnKey("Sep").rowKey(mediaChart.getSepColor()).doubleValue(sep).build();
                barChartDataEntityList.add(barChartDataEntitySep);
                oct = oct + ChartBuilder.parse(mediaRow.getOct());
                BarChartDataEntity barChartDataEntityOct = BarChartDataEntity.builder()
                        .columnKey("Oct").rowKey(mediaChart.getOctColor()).doubleValue(oct).build();
                barChartDataEntityList.add(barChartDataEntityOct);

                nov = nov + ChartBuilder.parse(mediaRow.getNov());
                BarChartDataEntity barChartDataEntityNov = BarChartDataEntity.builder()
                        .columnKey("Nov").rowKey(mediaChart.getNovColor()).doubleValue(nov).build();
                barChartDataEntityList.add(barChartDataEntityNov);
                dec = dec + ChartBuilder.parse(mediaRow.getDec());
                BarChartDataEntity barChartDataEntityDec = BarChartDataEntity.builder()
                        .columnKey("Dev").rowKey(mediaChart.getDecColor()).doubleValue(dec).build();
                barChartDataEntityList.add(barChartDataEntityDec);
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return barChartDataEntityList;

    }

}
