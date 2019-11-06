package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DE_RIESGO")
public class TipoDeRiesgo {
	
	@Id
	@Column(name = "ID_TIPO_RIESGO")
	private Integer idTipoRiesgo;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public TipoDeRiesgo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoRiesgo() {
		return idTipoRiesgo;
	}

	public void setIdTipoRiesgo(Integer idTipoRiesgo) {
		this.idTipoRiesgo = idTipoRiesgo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
