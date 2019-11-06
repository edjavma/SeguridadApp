package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_DE_BRECHA")
public class TipoBrecha {
	
	@Id
	@Column(name = "ID_TIPO_BRECHA")
	private Integer idTipoBrecha;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public TipoBrecha() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTipoBrecha() {
		return idTipoBrecha;
	}

	public void setIdTipoBrecha(Integer idTipoBrecha) {
		this.idTipoBrecha = idTipoBrecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
