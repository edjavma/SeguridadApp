package gt.seguridad.pojo.chart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Chart {

	private String type;
	@JsonInclude(Include.NON_DEFAULT)
	private boolean polar;
	
	public Chart() {
		// TODO Auto-generated constructor stub
	}
	
	public Chart(String type) {
		this.type = type;
	}
	
	public Chart(String type, boolean polar) {
		this.type = type;
		this.polar = polar;
	}
	
	public boolean isPolar() {
		return polar;
	}
	
	public void setPolar(boolean polar) {
		this.polar = polar;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
