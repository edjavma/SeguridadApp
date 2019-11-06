package gt.seguridad.pojo.chart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AxisY {
	
	private	Title title;
	@JsonInclude(Include.NON_NULL)
	private Integer min;
	@JsonInclude(Include.NON_NULL)
	private String gridLineInterpolation;
	@JsonInclude(Include.NON_NULL)
	private Integer lineWidth;
	
	public AxisY() {
		// TODO Auto-generated constructor stub
	}
	
	public AxisY(Title title) {
		this.title = title;
	}
	
	public AxisY(Title title, Integer min, String gridLineInterpolation, Integer lineWidth) {
		this.title = title;
		this.min = min;
		this.gridLineInterpolation = gridLineInterpolation;
		this.lineWidth = lineWidth;
	}
	
	public Integer getLineWidth() {
		return lineWidth;
	}
	
	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}

	public Title getTitle() {
		return title;
	}
	
	public void setTitle(Title title) {
		this.title = title;
	}
	
	public Integer getMin() {
		return min;
	}
	
	public void setMin(Integer min) {
		this.min = min;
	}
	
	public String getGridLineInterpolation() {
		return gridLineInterpolation;
	}
	
	public void setGridLineInterpolation(String gridLineInterpolation) {
		this.gridLineInterpolation = gridLineInterpolation;
	}
}
