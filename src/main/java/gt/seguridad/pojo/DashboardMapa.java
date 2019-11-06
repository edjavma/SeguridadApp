package gt.seguridad.pojo;

import java.util.List;

import gt.seguridad.pojo.chart.BarChart;
import gt.seguridad.pojo.chart.PieChart;
import gt.seguridad.pojo.chart.RadarChart;

public class DashboardMapa {
	
	private List<MapaRiesgo> data;
	private List<Evaluacion> evaluacion;
	private PieChart pieChart;
	private BarChart barChart;
	private RadarChart radarChart;
	private String resultado;
	
	public DashboardMapa() {
		// TODO Auto-generated constructor stub
	}

	public List<MapaRiesgo> getData() {
		return data;
	}

	public void setData(List<MapaRiesgo> data) {
		this.data = data;
	}
	
	public String getResultado() {
		return resultado;
	}
	
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public List<Evaluacion> getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(List<Evaluacion> evaluacion) {
		this.evaluacion = evaluacion;
	}

	public PieChart getPieChart() {
		return pieChart;
	}

	public void setPieChart(PieChart pieChart) {
		this.pieChart = pieChart;
	}

	public BarChart getBarChart() {
		return barChart;
	}

	public void setBarChart(BarChart barChart) {
		this.barChart = barChart;
	}

	public RadarChart getRadarChart() {
		return radarChart;
	}

	public void setRadarChart(RadarChart radarChart) {
		this.radarChart = radarChart;
	}
	
	

}
