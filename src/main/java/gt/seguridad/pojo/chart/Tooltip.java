package gt.seguridad.pojo.chart;

public class Tooltip {
	
	private boolean shared;
	private String pointFormat;
	
	public Tooltip() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Tooltip(boolean shared, String pointFormat) {
		super();
		this.shared = shared;
		this.pointFormat = pointFormat;
	}



	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	public String getPointFormat() {
		return pointFormat;
	}

	public void setPointFormat(String pointFormat) {
		this.pointFormat = pointFormat;
	}
	
	

}
