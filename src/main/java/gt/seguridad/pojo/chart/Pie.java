package gt.seguridad.pojo.chart;

public class Pie {
	
	private boolean allowPointSelect;
	private String cursor;
	private DataLabels dataLabels;
	private boolean showInLegend;

	public Pie() {
		// TODO Auto-generated constructor stub
	}
	
	public Pie(boolean allowPointSelect, String cursor, DataLabels dataLabels, boolean showInLegend) {
		this.allowPointSelect = allowPointSelect;
		this.cursor = cursor;
		this.dataLabels = dataLabels;
		this.showInLegend = showInLegend;
	}

	public boolean isAllowPointSelect() {
		return allowPointSelect;
	}

	public void setAllowPointSelect(boolean allowPointSelect) {
		this.allowPointSelect = allowPointSelect;
	}

	public String getCursor() {
		return cursor;
	}

	public void setCursor(String cursor) {
		this.cursor = cursor;
	}

	public DataLabels getDataLabels() {
		return dataLabels;
	}

	public void setDataLabels(DataLabels dataLabels) {
		this.dataLabels = dataLabels;
	}

	public boolean isShowInLegend() {
		return showInLegend;
	}

	public void setShowInLegend(boolean showInLegend) {
		this.showInLegend = showInLegend;
	}
	
	
}
