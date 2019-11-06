package gt.seguridad.pojo;

public class MapaRiesgo {

	private Integer idClasificacionRiesgo;
	private String nombre;
	private Integer bajo;
	private Integer medio;
	private Integer alto;
	private Integer critico;
	private String colorA;
	private String colorB;
	private String colorC;
	private String colorD;
	
	public MapaRiesgo() {
		// TODO Auto-generated constructor stub
	}
	
	

	public MapaRiesgo(Integer idClasificacionRiesgo,String nombre, Integer bajo, Integer medio, Integer alto, Integer critico, String colorA,
			String colorB, String colorC, String colorD) {
		super();
		this.idClasificacionRiesgo = idClasificacionRiesgo;
		this.nombre = nombre;
		this.bajo = bajo;
		this.medio = medio;
		this.alto = alto;
		this.critico = critico;
		this.colorA = colorA;
		this.colorB = colorB;
		this.colorC = colorC;
		this.colorD = colorD;
	}


	public Integer getIdClasificacionRiesgo() {
		return idClasificacionRiesgo;
	}
	
	public void setIdClasificacionRiesgo(Integer idClasificacionRiesgo) {
		this.idClasificacionRiesgo = idClasificacionRiesgo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getBajo() {
		return bajo;
	}

	public void setBajo(Integer bajo) {
		this.bajo = bajo;
	}

	public Integer getMedio() {
		return medio;
	}

	public void setMedio(Integer medio) {
		this.medio = medio;
	}

	public Integer getAlto() {
		return alto;
	}

	public void setAlto(Integer alto) {
		this.alto = alto;
	}

	public Integer getCritico() {
		return critico;
	}

	public void setCritico(Integer critico) {
		this.critico = critico;
	}

	public String getColorA() {
		return colorA;
	}

	public void setColorA(String colorA) {
		this.colorA = colorA;
	}

	public String getColorB() {
		return colorB;
	}

	public void setColorB(String colorB) {
		this.colorB = colorB;
	}

	public String getColorC() {
		return colorC;
	}

	public void setColorC(String colorC) {
		this.colorC = colorC;
	}

	public String getColorD() {
		return colorD;
	}

	public void setColorD(String colorD) {
		this.colorD = colorD;
	}
	
	
}
