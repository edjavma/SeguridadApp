package gt.seguridad.pojo;

import java.util.List;

import gt.seguridad.pojo.chart.LineChart;
import gt.seguridad.pojo.chart.PieChart;

public class Dashboard {

	private Integer total;
	private Double porcentajeTotal;
	private String resultado;	
	private Integer totalCritico;
	private Integer totalAlto;
	private Integer totalMedio;
	private Integer totalBajo;
	private Double totalPorcentajeCritico;
	private Double totalPorcentajeAlto;
	private Double totalPorcentajeMedio;
	private Double totalPorcentajeBajo;
	private List<Data> data;
	private List<Evaluacion> evaluacion;
	private PieChart pieChart;
	private LineChart lineChart;
	
	public Dashboard() {
		// TODO Auto-generated constructor stub
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getPorcentajeTotal() {
		return porcentajeTotal;
	}

	public void setPorcentajeTotal(Double porcentajeTotal) {
		this.porcentajeTotal = porcentajeTotal;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public Integer getTotalCritico() {
		return totalCritico;
	}

	public void setTotalCritico(Integer totalCritico) {
		this.totalCritico = totalCritico;
	}

	public Integer getTotalAlto() {
		return totalAlto;
	}

	public void setTotalAlto(Integer totalAlto) {
		this.totalAlto = totalAlto;
	}

	public Integer getTotalMedio() {
		return totalMedio;
	}

	public void setTotalMedio(Integer totalMedio) {
		this.totalMedio = totalMedio;
	}

	public Integer getTotalBajo() {
		return totalBajo;
	}

	public void setTotalBajo(Integer totalBajo) {
		this.totalBajo = totalBajo;
	}

	public Double getTotalPorcentajeCritico() {
		return totalPorcentajeCritico;
	}

	public void setTotalPorcentajeCritico(Double totalPorcentajeCritico) {
		this.totalPorcentajeCritico = totalPorcentajeCritico;
	}

	public Double getTotalPorcentajeAlto() {
		return totalPorcentajeAlto;
	}

	public void setTotalPorcentajeAlto(Double totalPorcentajeAlto) {
		this.totalPorcentajeAlto = totalPorcentajeAlto;
	}

	public Double getTotalPorcentajeMedio() {
		return totalPorcentajeMedio;
	}

	public void setTotalPorcentajeMedio(Double totalPorcentajeMedio) {
		this.totalPorcentajeMedio = totalPorcentajeMedio;
	}

	public Double getTotalPorcentajeBajo() {
		return totalPorcentajeBajo;
	}

	public void setTotalPorcentajeBajo(Double totalPorcentajeBajo) {
		this.totalPorcentajeBajo = totalPorcentajeBajo;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
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

	public LineChart getLineChart() {
		return lineChart;
	}

	public void setLineChart(LineChart lineChart) {
		this.lineChart = lineChart;
	}
	
	
	
}
