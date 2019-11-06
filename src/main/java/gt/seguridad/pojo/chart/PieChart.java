package gt.seguridad.pojo.chart;

import java.util.List;

public class PieChart {
	
	private Chart chart;
	private Title title;
	private Options plotOptions;
	private List<String> colors;
	private List<Series> series;
	
	public PieChart() {
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

	public Options getPlotOptions() {
		return plotOptions;
	}

	public void setPlotOptions(Options plotOptions) {
		this.plotOptions = plotOptions;
	}

	public List<String> getColors() {
		return colors;
	}

	public void setColors(List<String> colors) {
		this.colors = colors;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}
	
	
	

}
