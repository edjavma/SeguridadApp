package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DE_TRATAMIENTO")
public class TipoTratamiento {
	
	@Id
	@Column(name = "ID_TIPO_TRATAMIENTO")
	private Integer idTipoTratamiento;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public TipoTratamiento() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoTratamiento() {
		return idTipoTratamiento;
	}

	public void setIdTipoTratamiento(Integer idTipoTratamiento) {
		this.idTipoTratamiento = idTipoTratamiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
