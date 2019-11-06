package gt.seguridad.pojo;

public class Data {

	private String tipo;
	private Integer total;
	private Double porcentaje;
	private String nivelRiesgo;
	private Integer totalCritico;
	private Integer totalAlto;
	private Integer totalMedio;
	private Integer totalBajo;
	
	public Data() {
		// TODO Auto-generated constructor stub
	}

	public Data(String tipo, Integer total, Double porcentaje, String nivelRiesgo, Integer totalCritico,
			Integer totalAlto, Integer totalMedio, Integer totalbajo) {
		super();
		this.tipo = tipo;
		this.total = total;
		this.porcentaje = porcentaje;
		this.nivelRiesgo = nivelRiesgo;
		this.totalCritico = totalCritico;
		this.totalAlto = totalAlto;
		this.totalMedio = totalMedio;
		this.totalBajo = totalbajo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public String getNivelRiesgo() {
		return nivelRiesgo;
	}

	public void setNivelRiesgo(String nivelRiesgo) {
		this.nivelRiesgo = nivelRiesgo;
	}

	public Integer getTotalCritico() {
		return totalCritico;
	}

	public void setTotalCritico(Integer totalCritico) {
		this.totalCritico = totalCritico;
	}

	public Integer getTotalAlto() {
		return totalAlto;
	}

	public void setTotalAlto(Integer totalAlto) {
		this.totalAlto = totalAlto;
	}

	public Integer getTotalMedio() {
		return totalMedio;
	}

	public void setTotalMedio(Integer totalMedio) {
		this.totalMedio = totalMedio;
	}

	public Integer getTotalBajo() {
		return totalBajo;
	}

	public void setTotalBajo(Integer totalbajo) {
		this.totalBajo = totalbajo;
	}






	
	
}
