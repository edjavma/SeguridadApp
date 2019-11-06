package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DE_IMPACTO")
public class TipoImpacto {

	@Id
	@Column(name = "ID_TIPO_IMPACTO")
	private Integer idTipoImpacto;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public TipoImpacto() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoImpacto() {
		return idTipoImpacto;
	}

	public void setIdTipoImpacto(Integer idTipoImpacto) {
		this.idTipoImpacto = idTipoImpacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
