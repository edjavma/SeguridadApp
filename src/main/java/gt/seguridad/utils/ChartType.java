package gt.seguridad.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gt.seguridad.pojo.Data;
import gt.seguridad.pojo.Evaluacion;
import gt.seguridad.pojo.chart.AxisX;
import gt.seguridad.pojo.chart.AxisY;
import gt.seguridad.pojo.chart.BarChart;
import gt.seguridad.pojo.chart.Chart;
import gt.seguridad.pojo.chart.DataLabels;
import gt.seguridad.pojo.chart.Legend;
import gt.seguridad.pojo.chart.Line;
import gt.seguridad.pojo.chart.LineChart;
import gt.seguridad.pojo.chart.Options;
import gt.seguridad.pojo.chart.Pie;
import gt.seguridad.pojo.chart.PieChart;
import gt.seguridad.pojo.chart.RadarChart;
import gt.seguridad.pojo.chart.Series;
import gt.seguridad.pojo.chart.SeriesLine;
import gt.seguridad.pojo.chart.Title;
import gt.seguridad.pojo.chart.Tooltip;

public class ChartType {

	
	public static PieChart getPie(String title, List<Evaluacion> evaluaciones, Evaluacion selected) {
		PieChart chart = new PieChart();
		try {
			chart.setChart(new Chart("pie"));
			chart.setTitle(new Title(title));
			chart.setPlotOptions(new Options(
						new Pie(true,"pointer", 
								new DataLabels(true,"<b>{point.name}</b>: {point.percentage:.1f} %"), true)
					));
			chart.setColors(Arrays.asList("#FF0000", "#FFA500", "#FFFF00", "#008000"));
			
			List<Series> series = new ArrayList<>();
			Series serie = new Series();
			serie.setName("total");
			serie.setColorByPoint(true);
			List<gt.seguridad.pojo.chart.Data> data = new ArrayList<>();
			for(Evaluacion evaluacion: evaluaciones) {				
				gt.seguridad.pojo.chart.Data value = new gt.seguridad.pojo.chart.Data();
				
				value.setName(evaluacion.getNivelRiesgo());
				value.setY(evaluacion.getTotal());
				
				if(evaluacion.getNivelRiesgo().equalsIgnoreCase(selected.getNivelRiesgo())) {
					value.setSelected(true);
					value.setSliced(true);
				}else {
					value.setSelected(false);
					value.setSliced(false);
				}
				
				data.add(value);
			}
			
			serie.setData(data);
			series.add(serie);
			chart.setSeries(series);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chart;
	}
	
	public static LineChart getLine(String title, List<Evaluacion> evaluaciones, List<Data> values) {
		LineChart chart = new LineChart();
		try {
			chart.setChart(new Chart("line"));
			chart.setTitle(new Title(title));
			chart.setyAxis(new AxisY(new Title("total")));
			chart.setPlotOptions(new Options(
						new Line(
								new DataLabels(true), true)
					));
			
			List<SeriesLine> series = new ArrayList<>();
			
			List<String> categories = new ArrayList<>();
			for(Evaluacion evaluacion: evaluaciones) {				
				categories.add(evaluacion.getNivelRiesgo());
			}
			chart.setxAxis(new AxisX(categories));
			
			for(Data data: values) {
				SeriesLine serie = new SeriesLine();
				serie.setName(data.getTipo());
				serie.setData(Arrays.asList(data.getTotalCritico(), data.getTotalAlto(), data.getTotalMedio(), data.getTotalBajo()));
				series.add(serie);
			}
			
			chart.setSeries(series);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chart;
	}
	
	public static BarChart getBar(List<Evaluacion> evaluaciones) {
		BarChart chart = new BarChart();
		try {

			List<SeriesLine> series = new ArrayList<>();			
			List<String> categories = new ArrayList<>();			
			List<Integer> data = new ArrayList<>();
			
			chart.setChart(new Chart("bar"));
			chart.setTitle(new Title(null));
			chart.setyAxis(new AxisY(new Title(null)));
			
			
			SeriesLine serie = new SeriesLine();
			serie.setName("Total");
			for(Evaluacion evaluacion: evaluaciones) {				
				categories.add(evaluacion.getNivelRiesgo());
				data.add(evaluacion.getTotal());
			}
			chart.setxAxis(new AxisX(categories,"on",0));
			
			serie.setData(data);
			series.add(serie);
			chart.setSeries(series);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chart;
	}
	
	
	public static RadarChart getRadar(List<Evaluacion> evaluaciones) {
		RadarChart chart = new RadarChart();
		try {

			List<SeriesLine> series = new ArrayList<>();			
			List<String> categories = new ArrayList<>();			
			List<Integer> data = new ArrayList<>();
			
			chart.setChart(new Chart("line", true));
			chart.setTitle(new Title(null));
			chart.setyAxis(new AxisY(null,0,"polygon", 0));
			
			
			
			SeriesLine serie = new SeriesLine();
			serie.setName("Total");
			serie.setPointPlacement("on");
			for(Evaluacion evaluacion: evaluaciones) {				
				categories.add(evaluacion.getNivelRiesgo());
				data.add(evaluacion.getTotal());
			}
			chart.setxAxis(new AxisX(categories,"on",0));
			chart.setLegend(new Legend("right","middle"));
			chart.setTooltip(new Tooltip(true, "<span style=\"color:{series.color}\">{series.name}: <b>{point.y:,.0f}</b><br/>"));
			
			serie.setData(data);
			series.add(serie);
			chart.setSeries(series);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return chart;
	}
}
