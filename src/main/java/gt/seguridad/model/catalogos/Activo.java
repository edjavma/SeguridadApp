package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACTIVO")
public class Activo {
	
	@Id
	@Column(name = "ID_ACTIVO")
	private Integer idActivo;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Activo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdActivo() {
		return idActivo;
	}

	public void setIdActivo(Integer idActivo) {
		this.idActivo = idActivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
