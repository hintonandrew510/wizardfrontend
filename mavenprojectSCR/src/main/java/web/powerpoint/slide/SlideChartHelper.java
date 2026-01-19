/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.slide;

import java.awt.Rectangle;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFChart;
import org.apache.poi.xslf.usermodel.XSLFComment;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTAxDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTBoolean;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLblPos;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTDLbls;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumDataSource;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTNumVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPieSer;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTPlotArea;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTSerTx;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrData;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTStrVal;
import org.openxmlformats.schemas.drawingml.x2006.chart.STDLblPos;

/**
 *
 * @author andrewhinton
 */
public class SlideChartHelper {

    public static void PieChartFilter(List<PieChart> pieChartList, XSLFSlide slide) throws IOException {
        // find chart in the slide
        String slideNumber = slide.getSlideName();

        String pageName = null;
        List<XSLFComment> comments = slide.getComments();
        for (XSLFComment comment : comments) {
            pageName = comment.getText();

            break;

        }

        System.out.println(pageName);

        System.out.println(slideNumber);
        XSLFChart chart = null;
        for (POIXMLDocumentPart part : slide.getRelations()) {
            if (part instanceof XSLFChart) {
                chart = (XSLFChart) part;
                System.out.println("FOUND chart ");
                // String title = chart.getTitle().getBody().toString();

                break;
            } else {
                System.out.println("Part " + part);
            }
        }

        if (chart == null) {
            System.out.println("chart NOT found in the template");
            throw new IllegalStateException("chart not found in the template");
        }

        //add
        chart.setTitleOverlay(false);
        POIXMLDocumentPart xlsPart = chart.getRelations().get(0);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();

        CTChart ctChart = chart.getCTChart();
        Rectangle rectangle = new Rectangle(50, 50, 400, 400);
        //ctChart.setPlotArea(ctpa);

        // ... inside your chart creation logic
        XDDFChartData chartData = chart.createData(ChartTypes.PIE3D, null, null);
        chartData.setVaryColors(true);
        chart.plot(chartData);

        CTPlotArea plotArea = ctChart.getPlotArea();

        CTPieChart pieChart = plotArea.getPieChartArray(0);
        //Pie Chart Series
        CTPieSer ser = pieChart.getSerArray(0);

        // Access or create the Data Labels (CTDLbls) element
        CTDLbls dLbls;
        if (ser.getDLbls() != null) {
            dLbls = ser.getDLbls();
        } else {
            dLbls = ser.addNewDLbls();
        }
        CTBoolean showPercent = dLbls.addNewShowPercent();
        showPercent.setVal(true);

// Hide the legend key in the data label (optional, usually preferred)
        CTBoolean showLegendKey = dLbls.addNewShowLegendKey();
        showLegendKey.setVal(false);

// Set the position of the data labels (e.g., outside the end)
        CTDLblPos dLblPos = dLbls.addNewDLblPos();
        dLblPos.setVal(STDLblPos.OUT_END);
        String chartTitle = "";
        // Series Text
        CTSerTx tx = ser.getTx();
        tx.getStrRef().getStrCache().getPtArray(0).setV(chartTitle);
        sheet.createRow(0).createCell(1).setCellValue(chartTitle);
        String titleRef = new CellReference(sheet.getSheetName(), 0, 1, true, true).formatAsString();
        tx.getStrRef().setF(titleRef);

        // Category Axis Data
        CTAxDataSource cat = ser.getCat();
        CTStrData strData = cat.getStrRef().getStrCache();

        // Values
        CTNumDataSource val = ser.getVal();
        CTNumData numData = val.getNumRef().getNumCache();

        strData.setPtArray(null);  // unset old axis text
        numData.setPtArray(null);  // unset old values
        int idx = 0;
        int rownum = 1;
        for (PieChart pieChartItem : pieChartList) {

            CTNumVal numVal = numData.addNewPt();
            numVal.setIdx(idx);
            String valueStr = String.valueOf(pieChartItem.getLabelValue());
            numVal.setV(valueStr);
            double doubleValue = pieChartItem.getLabelValue();
            CTStrVal sVal = strData.addNewPt();
            sVal.setIdx(idx);
            sVal.setV(pieChartItem.getLabel());

            idx++;
            XSSFRow row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(pieChartItem.getLabel());
            row.createCell(1).setCellValue(doubleValue);
        }

        numData.getPtCount().setVal(idx);
        strData.getPtCount().setVal(idx);

        String numDataRange = new CellRangeAddress(1, rownum - 1, 1, 1).formatAsString(sheet.getSheetName(), true);
        val.getNumRef().setF(numDataRange);
        String axisDataRange = new CellRangeAddress(1, rownum - 1, 0, 0).formatAsString(sheet.getSheetName(), true);
        cat.getStrRef().setF(axisDataRange);

        // updated the embedded workbook with the data
        OutputStream xlsOut = xlsPart.getPackagePart().getOutputStream();
        wb.write(xlsOut);
        xlsOut.close();

        System.out.println("done");

    }

    public static void main(String[] args) throws Exception {
        //String template = "/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/chartDemo.pptx";
         String template = "/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/pie-chart-template.pptx";
      
        org.apache.poi.openxml4j.util.ZipSecureFile.setMinInflateRatio(0.001); // or a different value as needed
        List<PieChart> pieChartList = new ArrayList<PieChart>();
        PieChart pieChartOne = new PieChart("apple", 1);
        PieChart pieChartTwo = new PieChart("banna", 2);
        pieChartList.add(pieChartOne);
        pieChartList.add(pieChartTwo);

        XMLSlideShow pptx = new XMLSlideShow(new FileInputStream(template));
        XSLFSlide slide = pptx.getSlides().get(0);
        String pageName = null;
        List<XSLFComment> comments = slide.getComments();
        for (XSLFComment comment : comments) {
            pageName = comment.getText();

            break;

        }
        PieChartFilter(pieChartList, slide);
          // save the result
        FileOutputStream out = new FileOutputStream("./pie3d-chart-demo-outputTV.pptx");
        pptx.write(out);

        System.out.println("file created");
        out.close();
    }

}
