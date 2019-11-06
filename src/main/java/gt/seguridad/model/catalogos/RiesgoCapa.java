package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RIESGO_CAPA")
public class RiesgoCapa {
	
	@Id
	@Column(name = "ID_RIESGO_CAPA")
	private Integer idRiesgoCapa;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public RiesgoCapa() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdRiesgoCapa() {
		return idRiesgoCapa;
	}
	
	public void setIdRiesgoCapa(Integer idRiesgoCapa) {
		this.idRiesgoCapa = idRiesgoCapa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
