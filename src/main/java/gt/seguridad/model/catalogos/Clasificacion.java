package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASIFICACION")
public class Clasificacion {

	@Id
	@Column(name = "ID_CLASIFICACION")
	private Integer idClasificacion;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Clasificacion() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(Integer idClasificacion) {
		this.idClasificacion = idClasificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
