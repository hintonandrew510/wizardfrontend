/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.jfree;

/**
 *
 * @author andrewhinton
 */
import java.io.*; 

import org.jfree.chart.ChartFactory; 
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.plot.PiePlot3D; 
import org.jfree.data.general.DefaultPieDataset; 
import org.jfree.chart.ChartUtils;
import org.jfree.chart.util.TableOrder;

public class PieChart3D {

   public static void main( String[ ] args )throws Exception {
      DefaultPieDataset dataset = new DefaultPieDataset( );             
      dataset.setValue( "IPhone 5s" , new Double( 20 ) );             
      dataset.setValue( "SamSung Grand" , new Double( 20 ) );             
      dataset.setValue( "MotoG" , new Double( 40 ) );             
      dataset.setValue( "Nokia Lumia" , new Double( 10 ) ); 
//ChartFactory.createMultiplePieChart3D("", dataset, TableOrder.BY_ROW, true, true, true);
      JFreeChart chart = ChartFactory.createPieChart3D( 
         "Mobile Sales" ,  // chart title                   
         dataset ,         // data 
         true ,            // include legend                   
         true, 
         false);

      final PiePlot3D plot = ( PiePlot3D ) chart.getPlot( );             
      plot.setStartAngle( 270 );             
      plot.setForegroundAlpha( 0.60f );             
      plot.setInteriorGap( 0.02 );             
      int width = 640;   /* Width of the image */             
      int height = 480;  /* Height of the image */                             
      File pieChart3D = new File( "pie_Chart3D.jpeg" );                           
      ChartUtils.saveChartAsJPEG( pieChart3D , chart , width , height );  
      System.out.println("Chart saved to " + pieChart3D.getAbsolutePath());
   }
}
