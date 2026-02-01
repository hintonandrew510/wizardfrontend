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
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.page.PieChart;
/**
 *
 * @author andrewhinton
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Data // Generates getters, setters, toString, equals, hashCode, and a required-args constructor
public class BarChartDataEntity {
    private double doubleValue;
    private String rowKey;
    private String columnKey;
  
    
}
