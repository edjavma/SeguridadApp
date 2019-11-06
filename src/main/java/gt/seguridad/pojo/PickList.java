package gt.seguridad.pojo;

import java.util.List;

public class PickList<T> {
	private List<T> source;
	private List<T> target;
	private Integer id;
	
	public PickList() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<T> getSource() {
		return source;
	}
	
	public void setSource(List<T> source) {
		this.source = source;
	}
	
	public List<T> getTarget() {
		return target;
	}
	
	public void setTarget(List<T> target) {
		this.target = target;
	}
	
}
