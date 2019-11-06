package gt.seguridad.pojo.chart;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class SeriesLine {

	private String name;
	private List<Integer> data;
	@JsonInclude(Include.NON_NULL)
	private String pointPlacement;
	
	public SeriesLine() {
		// TODO Auto-generated constructor stub
	}
	
	public String getPointPlacement() {
		return pointPlacement;
	}
	
	public void setPointPlacement(String pointPlacement) {
		this.pointPlacement = pointPlacement;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getData() {
		return data;
	}
	
	public void setData(List<Integer> data) {
		this.data = data;
	}
	
	
}
