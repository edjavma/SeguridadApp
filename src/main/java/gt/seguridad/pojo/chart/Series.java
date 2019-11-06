package gt.seguridad.pojo.chart;

import java.util.List;

public class Series {
	
	private String name;
	private boolean colorByPoint;
	private List<Data> data;
	
	public Series() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isColorByPoint() {
		return colorByPoint;
	}

	public void setColorByPoint(boolean colorByPoint) {
		this.colorByPoint = colorByPoint;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
	
	

}
