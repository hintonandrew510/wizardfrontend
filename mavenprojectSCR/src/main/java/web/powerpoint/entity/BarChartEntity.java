/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.powerpoint.entity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data; 
import lombok.Getter;
import lombok.Setter;
import web.page.PieChart;
/**
 *
 * @author andrewhinton
 */
@Getter
@Setter
@Builder
@AllArgsConstructor // Generates the constructor needed by @Builder
//@Data // Generates getters, setters, toString, equals, hashCode, and a required-args constructor
public class BarChartEntity {
    private String topTitle;
    private String bottomTitle;
    private String yAxis;
    private String xAxis;
    private String fileName;
    private List<BarChartDataEntity> barChartDataEntityList;
    
}
