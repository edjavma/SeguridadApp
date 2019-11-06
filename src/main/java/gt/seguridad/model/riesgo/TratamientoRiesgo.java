package gt.seguridad.model.riesgo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gt.seguridad.model.catalogos.Solucion;

@Entity
@Table(name = "TRATAMIENTO_RIESGO")
public class TratamientoRiesgo {
	
	@Id
	@Column(name = "ID_TRATAMIENTO_RIESGO")
	private Integer idTratamientoRiesgo;
	@ManyToOne
	@JoinColumn(name = "CORRELATIVO", referencedColumnName = "CORRELATIVO")
	private EvaluacionRiesgo correlativo;
	@ManyToOne
	@JoinColumn(name = "ID_SOLUCION", referencedColumnName = "ID_SOLUCION")
	private Solucion idSolucion;
	
	public TratamientoRiesgo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdTratamientoRiesgo() {
		return idTratamientoRiesgo;
	}

	public void setIdTratamientoRiesgo(Integer idTratamientoRiesgo) {
		this.idTratamientoRiesgo = idTratamientoRiesgo;
	}

	public EvaluacionRiesgo getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(EvaluacionRiesgo correlativo) {
		this.correlativo = correlativo;
	}

	public Solucion getIdSolucion() {
		return idSolucion;
	}

	public void setIdSolucion(Solucion idSolucion) {
		this.idSolucion = idSolucion;
	}
	
	

}
