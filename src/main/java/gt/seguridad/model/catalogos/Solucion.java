package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SOLUCION")
public class Solucion {
	
	@Id
	@Column(name = "ID_SOLUCION")
	private Integer idSolucion;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public Solucion() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdSolucion() {
		return idSolucion;
	}

	public void setIdSolucion(Integer idSolucion) {
		this.idSolucion = idSolucion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}