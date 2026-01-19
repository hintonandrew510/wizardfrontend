/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint;

import java.awt.Rectangle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFChart;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;
import org.apache.poi.xslf.usermodel.*;

import java.io.*;
import java.util.List;
import org.apache.poi.ooxml.POIXMLDocumentPart;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;

/**
 * Build a pie chart from a template pptx
 *
 * @author Yegor Kozlov
 */
public class PieChartDemoPercentage {

    private static void usage() {
        System.out.println("Usage: PieChartDemo <pie-chart-template.pptx> <pie-chart-data.txt>");
        System.out.println("    pie-chart-template.pptx     template with a pie chart");
        System.out.println("    pie-chart-data.txt          the model to set. First line is chart title, "
                + "then go pairs {axis-label value}");
    }

    public static void main(String[] args) throws Exception {
//        if(args.length < 2) {
//            usage();
//            return;
//    
        String template = "/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/pie-chart-template.pptx";
      
        //template="/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/powerpointtemplate/tv.pptx";
        String dataFile = "/Users/andrewhinton/Documents/GitHub/wizardfrontend/mavenprojectSCR/src/main/resources/pie-chart-data.txt";
        BufferedReader modelReader = new BufferedReader(new FileReader(dataFile));

        String chartTitle = modelReader.readLine();  // first line is chart title

        XMLSlideShow pptx = new XMLSlideShow(new FileInputStream(template));
        XSLFSlide slide = pptx.getSlides().get(0);
        
        System.out.println("found chart " + slide.getSlideName() );
      

        // find chart in the slide
        XSLFChart chart = null;
        for (POIXMLDocumentPart part : slide.getRelations()) {
            if (part instanceof XSLFChart) {
                chart = (XSLFChart) part;
                System.out.println("FOUND chart " );
               // String title = chart.getTitle().getBody().toString();
                
                break;
            } else {
                 System.out.println("Part " + part );
            }
        }

        if (chart == null) {
            System.out.println("chart NOT found in the template");
            throw new IllegalStateException("chart not found in the template");
        }

        //add
        chart.setTitleOverlay(false);

        
       
        //XSLFChart chart = slide.addChart(ppt.createChart(), rect);

        // embedded Excel workbook that holds the chart data
         List<POIXMLDocumentPart> allparts = chart.getRelations();
         for (POIXMLDocumentPart indPart : allparts) {
            System.out.println(" part " +indPart.getClass().getName() );
         }
         
        POIXMLDocumentPart xlsPart = chart.getRelations().get(0);
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet();

        CTChart ctChart = chart.getCTChart();
        Rectangle rectangle = new Rectangle(50, 50, 400, 400);
        //ctChart.setPlotArea(ctpa);

        // ... inside your chart creation logic
        XDDFChartData chartData = chart.createData(ChartTypes.PIE, null, null);
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

        // Configure the data labels to show specific information:
// Show the value (the numerical data point)
        // CTBoolean showVal = dLbls.addNewShowVal();
        //showVal.setVal(true);
// Show the category name (the label for the slice)
        // CTBoolean showCatName = dLbls.addNewShowCatName();
        //ploshowCatName.setVal(true);
// Show the percentage (useful for pie charts)
        CTBoolean showPercent = dLbls.addNewShowPercent();
        showPercent.setVal(true);

// Hide the legend key in the data label (optional, usually preferred)
        CTBoolean showLegendKey = dLbls.addNewShowLegendKey();
        showLegendKey.setVal(false);

// Set the position of the data labels (e.g., outside the end)
        CTDLblPos dLblPos = dLbls.addNewDLblPos();
        dLblPos.setVal(STDLblPos.OUT_END);

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

        // set model
        int idx = 0;
        int rownum = 1;
        String ln;
        while ((ln = modelReader.readLine()) != null) {
            String[] vals = ln.split("\\s+");
            CTNumVal numVal = numData.addNewPt();
            numVal.setIdx(idx);
            numVal.setV(vals[1]);

            CTStrVal sVal = strData.addNewPt();
            sVal.setIdx(idx);
            sVal.setV(vals[0]);

            idx++;
            XSSFRow row = sheet.createRow(rownum++);
            row.createCell(0).setCellValue(vals[0]);
            row.createCell(1).setCellValue(Double.valueOf(vals[1]));
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

        // save the result
        FileOutputStream out = new FileOutputStream("./pie3d-chart-demo-outputTV.pptx");
        pptx.write(out);

        System.out.println("file created");
        out.close();
    }
}
