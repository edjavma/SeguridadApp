package gt.seguridad.pojo.chart;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Options {
	
	@JsonInclude(Include.NON_NULL)
	private Pie pie;
	@JsonInclude(Include.NON_NULL)
	private Line line;
	
	public Options() {
		// TODO Auto-generated constructor stub
	}
	
	public Options(Line line) {
		this.line = line;
	}
	
	
	public Options(Pie pie) {
		this.pie = pie;
	}
	
	public Line getLine() {
		return line;
	}
	
	public void setLine(Line line) {
		this.line = line;
	}
	
	public Pie getPie() {
		return pie;
	}
	
	public void setPie(Pie pie) {
		this.pie = pie;
	}

}
