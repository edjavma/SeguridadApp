package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RESPONSABLE")
public class Responsable {

	@Id
	@Column(name = "ID_RESPONSABLE")
	private Integer idResponsable;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Responsable() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(Integer idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
