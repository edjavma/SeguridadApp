package gt.seguridad.pojo.chart;

public class Line {

	private DataLabels dataLabels;
	private boolean enableMouseTracking;
	
	public Line() {
		// TODO Auto-generated constructor stub
	}
	
	public Line(DataLabels dataLabels, boolean enableMouseTracking) {
		this.dataLabels = dataLabels;
		this.enableMouseTracking = enableMouseTracking;
	}
	
	public DataLabels getDataLabels() {
		return dataLabels;
	}
	
	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}
	
	public boolean isEnableMouseTracking() {
		return enableMouseTracking;
	}
	
	public void setEnableMouseTracking(boolean enableMouseTracking) {
		this.enableMouseTracking = enableMouseTracking;
	}
	
}
