package gt.seguridad.pojo.chart;

import java.util.List;

public class BarChart {
	
	private Chart chart;
	private Title title;
	private AxisX xAxis;
	private AxisY yAxis;
	private List<SeriesLine> series;

	public BarChart() {
		// TODO Auto-generated constructor stub
	}

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public AxisX getxAxis() {
		return xAxis;
	}

	public void setxAxis(AxisX xAxis) {
		this.xAxis = xAxis;
	}

	public AxisY getyAxis() {
		return yAxis;
	}

	public void setyAxis(AxisY yAxis) {
		this.yAxis = yAxis;
	}

	public List<SeriesLine> getSeries() {
		return series;
	}

	public void setSeries(List<SeriesLine> series) {
		this.series = series;
	}
	
	
	
}
