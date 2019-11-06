package gt.seguridad.model.catalogos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARQUITECTURA_APLICACION")
public class ArquitecturaAplicacion {
	
	@Id
	@Column(name = "ID_ARQUITECTURA")
	private Integer idArquitectura;
	@Column(name = "NOMBRE")
	private String nombre;
	
	public ArquitecturaAplicacion() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdArquitectura() {
		return idArquitectura;
	}

	public void setIdArquitectura(Integer idArquitectura) {
		this.idArquitectura = idArquitectura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
