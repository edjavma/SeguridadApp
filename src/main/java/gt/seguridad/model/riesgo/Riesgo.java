package gt.seguridad.model.riesgo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import gt.seguridad.model.catalogos.GeneradorRiesgo;
import gt.seguridad.model.catalogos.Responsable;
import gt.seguridad.model.catalogos.RiesgoCapa;
import gt.seguridad.model.catalogos.TipoBrecha;
import gt.seguridad.model.catalogos.TipoDeRiesgo;
import gt.seguridad.model.catalogos.TipoImpacto;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "Riesgo.findNonEval",
			query = "SELECT R.* FROM RIESGO R " + 
					"WHERE NOT EXISTS (SELECT 1 FROM EVALUACION_RIESGO E WHERE E.ID_RIESGO = R.ID_RIESGO AND E.ID_ARQUITECTURA = ?1 )  " + 
					"ORDER BY R.ID_RIESGO DESC ",
			resultClass = Riesgo.class)
})
@Table(name = "RIESGO")
public class Riesgo {
	
	@Id
	@Column(name = "ID_RIESGO")
	private Integer idRiesgo;
	@Column(name = "NOMBRE")
	private String nombre;
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_RIESGO", referencedColumnName = "ID_TIPO_RIESGO")
	private TipoDeRiesgo idTipoRiesgo;
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_IMPACTO", referencedColumnName = "ID_TIPO_IMPACTO")
	private TipoImpacto idTipoImpacto;
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_BRECHA", referencedColumnName = "ID_TIPO_BRECHA")
	private TipoBrecha idTipoBrecha;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Column(name = "CAUSA")
	private String causa;
	@Column(name = "CONSECUENCIAS")
	private String consecuencias;
	@Column(name = "ACCION_CORRECTIVA")
	private String accionCorrectiva;
	@ManyToOne
	@JoinColumn(name = "ID_RIESGO_CAPA", referencedColumnName = "ID_RIESGO_CAPA")
	private RiesgoCapa idRiesgoCapa;
	@ManyToOne
	@JoinColumn(name = "ID_GENERADOR_RIESGO", referencedColumnName = "ID_GENERADOR_RIESGO")
	private GeneradorRiesgo idGeneradorRiesgo;
	@ManyToOne
	@JoinColumn(name = "ID_RESPONSABLE", referencedColumnName = "ID_RESPONSABLE")
	private Responsable idResponsable;
	@Column(name = "USUARIO")
	private String usuario;
	@Column(name = "FECHA_INGRESO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;
	
	@Transient
	private Integer id;
	
	@Transient
	private String identificador;
	
	
	
	public Riesgo() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Integer getIdRiesgo() {
		return idRiesgo;
	}

	public void setIdRiesgo(Integer idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoDeRiesgo getIdTipoRiesgo() {
		return idTipoRiesgo;
	}

	public void setIdTipoRiesgo(TipoDeRiesgo idTipoRiesgo) {
		this.idTipoRiesgo = idTipoRiesgo;
	}

	public TipoImpacto getIdTipoImpacto() {
		return idTipoImpacto;
	}

	public void setIdTipoImpacto(TipoImpacto idTipoImpacto) {
		this.idTipoImpacto = idTipoImpacto;
	}

	public TipoBrecha getIdTipoBrecha() {
		return idTipoBrecha;
	}

	public void setIdTipoBrecha(TipoBrecha idTipoBrecha) {
		this.idTipoBrecha = idTipoBrecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public String getConsecuencias() {
		return consecuencias;
	}

	public void setConsecuencias(String consecuencias) {
		this.consecuencias = consecuencias;
	}

	public String getAccionCorrectiva() {
		return accionCorrectiva;
	}

	public void setAccionCorrectiva(String accionCorrectiva) {
		this.accionCorrectiva = accionCorrectiva;
	}

	public RiesgoCapa getIdRiesgoCapa() {
		return idRiesgoCapa;
	}
	
	public void setIdRiesgoCapa(RiesgoCapa idRiesgoCapa) {
		this.idRiesgoCapa = idRiesgoCapa;
	}

	public GeneradorRiesgo getIdGeneradorRiesgo() {
		return idGeneradorRiesgo;
	}

	public void setIdGeneradorRiesgo(GeneradorRiesgo idGeneradorRiesgo) {
		this.idGeneradorRiesgo = idGeneradorRiesgo;
	}

	public Responsable getIdResponsable() {
		return idResponsable;
	}

	public void setIdResponsable(Responsable idResponsable) {
		this.idResponsable = idResponsable;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	
	

}
