package gt.seguridad.pojo.chart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DataLabels {

	private boolean enabled;
	@JsonInclude(Include.NON_NULL)
	private String format;
	
	public DataLabels() {
		// TODO Auto-generated constructor stub
	}
	
	public DataLabels(boolean enabled) {
		this.enabled = enabled;
	}
	
	public DataLabels(boolean enabled, String format) {
		this.enabled = enabled;
		this.format = format;
	}
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
