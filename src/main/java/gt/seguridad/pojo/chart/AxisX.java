package gt.seguridad.pojo.chart;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AxisX {

	private List<String> categories;
	@JsonInclude(Include.NON_NULL)
	private String tickmarkPlacement;
	@JsonInclude(Include.NON_NULL)
	private Integer lineWidth;
	
	public AxisX() {
		// TODO Auto-generated constructor stub
	}
	
	public AxisX(List<String> categories) {
		this.categories = categories;
	}
	
	public AxisX(List<String> categories, String tickmarkPlacement, Integer lineWidth) {
		this.categories = categories;
		this.tickmarkPlacement = tickmarkPlacement;
		this.lineWidth = lineWidth;
	}
	
	
	
	public String getTickmarkPlacement() {
		return tickmarkPlacement;
	}

	public void setTickmarkPlacement(String tickmarkPlacement) {
		this.tickmarkPlacement = tickmarkPlacement;
	}

	public Integer getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(Integer lineWidth) {
		this.lineWidth = lineWidth;
	}

	public List<String> getCategories() {
		return categories;
	}
	
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
