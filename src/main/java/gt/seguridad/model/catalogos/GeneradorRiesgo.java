package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GENERADOR_RIESGO")
public class GeneradorRiesgo {
	
	@Id
	@Column(name = "ID_GENERADOR_RIESGO")
	private Integer idGeneradorRiesgo;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public GeneradorRiesgo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdGeneradorRiesgo() {
		return idGeneradorRiesgo;
	}

	public void setIdGeneradorRiesgo(Integer idGeneradorRiesgo) {
		this.idGeneradorRiesgo = idGeneradorRiesgo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
