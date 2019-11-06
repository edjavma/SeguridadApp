package gt.seguridad.pojo;

public class Evaluacion {
	
	private String nivelRiesgo;
	private Integer total;
	private Double porcentaje;
	
	public Evaluacion() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Evaluacion(String nivelRiesgo, Integer total, Double porcentaje) {
		super();
		this.nivelRiesgo = nivelRiesgo;
		this.total = total;
		this.porcentaje = porcentaje;
	}



	public String getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(String nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Double getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

}
