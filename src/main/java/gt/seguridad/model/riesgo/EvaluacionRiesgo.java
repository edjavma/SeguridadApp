package gt.seguridad.model.riesgo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.WhereJoinTable;

import gt.seguridad.model.catalogos.Activo;
import gt.seguridad.model.catalogos.ArquitecturaAplicacion;
import gt.seguridad.model.catalogos.Clasificacion;
import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.catalogos.TipoTratamiento;
import gt.seguridad.pojo.Data;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "EvaluacionRiesgo.getInfoDashboardRiesgo",
			query = "SELECT TIPO, TOTAL, PORCENTAJE, PKG_DASHBOARD.NIVEL_MAX_RIESGO(ID_TIPO_RIESGO) NIVEL_RIESGO, "+
					"PKG_DASHBOARD.OBTENER_NIVEL_RIESGO(4, ID_TIPO_RIESGO) TOTAL_CRITICO, " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_RIESGO(3, ID_TIPO_RIESGO) TOTAL_ALTO, " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_RIESGO(2, ID_TIPO_RIESGO) TOTAL_MEDIO, " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_RIESGO(1, ID_TIPO_RIESGO) TOTAL_BAJO FROM ( " + 
					"SELECT INITCAP(T.NOMBRE) TIPO,T.ID_TIPO_RIESGO, COUNT(*) TOTAL, ROUND((COUNT(*) * 100) / (SELECT SUM(TOTAL) FROM ( " + 
					"SELECT T.NOMBRE TIPO, COUNT(*) TOTAL " + 
					"FROM EVALUACION_RIESGO E " + 
					"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO " + 
					"INNER JOIN TIPO_DE_RIESGO T ON R.ID_TIPO_RIESGO = T.ID_TIPO_RIESGO " +
					"WHERE E.APLICA = 1 "+
					"GROUP BY T.NOMBRE)) , 2) PORCENTAJE " + 
					"FROM EVALUACION_RIESGO E " + 
					"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO " + 
					"INNER JOIN TIPO_DE_RIESGO T ON R.ID_TIPO_RIESGO = T.ID_TIPO_RIESGO " + 
					"WHERE E.APLICA = 1 "+
					"GROUP BY T.NOMBRE, T.ID_TIPO_RIESGO) ",
			resultSetMapping = "ResultsData"),
	@NamedNativeQuery(name = "EvaluacionRiesgo.getInfoDashboardImpacto",
			query = "SELECT TIPO, TOTAL, PORCENTAJE,    " + 
					"PKG_DASHBOARD.NIVEL_MAX_IMPACTO(ID_TIPO_IMPACTO) NIVEL_RIESGO,   " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_IMPACTO(4, ID_TIPO_IMPACTO) TOTAL_CRITICO,   " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_IMPACTO(3, ID_TIPO_IMPACTO) TOTAL_ALTO,   " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_IMPACTO(2, ID_TIPO_IMPACTO) TOTAL_MEDIO,   " + 
					"PKG_DASHBOARD.OBTENER_NIVEL_IMPACTO(1, ID_TIPO_IMPACTO) TOTAL_BAJO FROM (   " + 
					"SELECT INITCAP(T.NOMBRE) TIPO,T.ID_TIPO_IMPACTO, COUNT(*) TOTAL, ROUND((COUNT(*) * 100) / (SELECT SUM(TOTAL) FROM (   " + 
					"SELECT T.NOMBRE TIPO, COUNT(*) TOTAL   " + 
					"FROM EVALUACION_RIESGO E   " + 
					"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO   " + 
					"INNER JOIN TIPO_DE_IMPACTO T ON R.ID_TIPO_IMPACTO = T.ID_TIPO_IMPACTO   " + 
					"WHERE E.APLICA = 1 "+
					"GROUP BY T.NOMBRE)) , 2) PORCENTAJE   " + 
					"FROM EVALUACION_RIESGO E   " + 
					"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO   " + 
					"INNER JOIN TIPO_DE_IMPACTO T ON R.ID_TIPO_IMPACTO = T.ID_TIPO_IMPACTO   " + 
					"WHERE E.APLICA = 1 "+
					"GROUP BY T.NOMBRE, T.ID_TIPO_IMPACTO) ",
				resultSetMapping = "ResultsData"),
	@NamedNativeQuery(name = "EvaluacionRiesgo.getInfoDashboardBrecha",
				query = "SELECT TIPO, TOTAL, PORCENTAJE,     " + 
						"PKG_DASHBOARD.NIVEL_MAX_BRECHA(ID_TIPO_BRECHA) NIVEL_RIESGO,    " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_BRECHA(4, ID_TIPO_BRECHA) TOTAL_CRITICO,    " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_BRECHA(3, ID_TIPO_BRECHA) TOTAL_ALTO,    " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_BRECHA(2, ID_TIPO_BRECHA) TOTAL_MEDIO,    " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_BRECHA(1, ID_TIPO_BRECHA) TOTAL_BAJO FROM (    " + 
						"SELECT INITCAP(T.NOMBRE) TIPO,T.ID_TIPO_BRECHA, COUNT(*) TOTAL, ROUND((COUNT(*) * 100) / (SELECT SUM(TOTAL) FROM (    " + 
						"SELECT T.NOMBRE TIPO, COUNT(*) TOTAL    " + 
						"FROM EVALUACION_RIESGO E    " + 
						"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO    " + 
						"INNER JOIN TIPO_DE_BRECHA T ON R.ID_TIPO_BRECHA = T.ID_TIPO_BRECHA    " + 
						"WHERE E.APLICA = 1 "+
						"GROUP BY T.NOMBRE)) , 2) PORCENTAJE    " + 
						"FROM EVALUACION_RIESGO E    " + 
						"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO    " + 
						"INNER JOIN TIPO_DE_BRECHA T ON R.ID_TIPO_BRECHA = T.ID_TIPO_BRECHA    " + 
						"WHERE E.APLICA = 1 "+
						"GROUP BY T.NOMBRE, T.ID_TIPO_BRECHA) ",
				resultSetMapping = "ResultsData"),
	@NamedNativeQuery(name = "EvaluacionRiesgo.getInfoDashboardTratamiento",
				query = "SELECT TIPO, TOTAL, PORCENTAJE,    " + 
						"PKG_DASHBOARD.NIVEL_MAX_TRATAMIENTO(ID_TIPO_TRATAMIENTO) NIVEL_RIESGO,   " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_TRATAMIENTO(4, ID_TIPO_TRATAMIENTO) TOTAL_CRITICO,   " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_TRATAMIENTO(3, ID_TIPO_TRATAMIENTO) TOTAL_ALTO,   " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_TRATAMIENTO(2, ID_TIPO_TRATAMIENTO) TOTAL_MEDIO,   " + 
						"PKG_DASHBOARD.OBTENER_NIVEL_TRATAMIENTO(1, ID_TIPO_TRATAMIENTO) TOTAL_BAJO FROM (   " + 
						"SELECT INITCAP(T.NOMBRE) TIPO,T.ID_TIPO_TRATAMIENTO, COUNT(*) TOTAL, ROUND((COUNT(*) * 100) / (SELECT SUM(TOTAL) FROM (   " + 
						"SELECT T.NOMBRE TIPO, COUNT(*) TOTAL   " + 
						"FROM EVALUACION_RIESGO E   " + 
						"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO   " + 
						"INNER JOIN TIPO_DE_TRATAMIENTO T ON E.ID_TIPO_TRATAMIENTO = T.ID_TIPO_TRATAMIENTO   " + 
						"WHERE E.APLICA = 1 "+
						"GROUP BY T.NOMBRE)) , 2) PORCENTAJE   " + 
						"FROM EVALUACION_RIESGO E   " + 
						"INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO   " + 
						"INNER JOIN TIPO_DE_TRATAMIENTO T ON E.ID_TIPO_TRATAMIENTO = T.ID_TIPO_TRATAMIENTO   " + 
						"WHERE E.APLICA = 1 "+
						"GROUP BY T.NOMBRE, T.ID_TIPO_TRATAMIENTO) ",
				resultSetMapping = "ResultsData")
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name = "ResultsData",
			classes = {
					@ConstructorResult(targetClass = Data.class,
							columns = {
									@ColumnResult(name = "TIPO", type = String.class),
									@ColumnResult(name = "TOTAL", type = Integer.class),
									@ColumnResult(name = "PORCENTAJE", type = Double.class),
									@ColumnResult(name = "NIVEL_RIESGO", type = String.class),
									@ColumnResult(name = "TOTAL_CRITICO", type = Integer.class),
									@ColumnResult(name = "TOTAL_ALTO", type = Integer.class),
									@ColumnResult(name = "TOTAL_MEDIO", type = Integer.class),
									@ColumnResult(name = "TOTAL_BAJO", type = Integer.class)
							})					
			})
})
@Table(name = "EVALUACION_RIESGO")
public class EvaluacionRiesgo {
	
	@Id
	@Column(name = "CORRELATIVO")
	private Integer correlativo;
	@ManyToOne
	@JoinColumn(name = "ID_RIESGO", referencedColumnName = "ID_RIESGO")
	private Riesgo idRiesgo;
	@Column(name = "PROBABILIDAD")
	private Integer probabilidad;
	@Column(name = "IMPACTO")
	private Integer impacto;
	@ManyToOne
	@JoinColumn(name = "ID_ACTIVO", referencedColumnName = "ID_ACTIVO")
	private Activo idActivo;
	@ManyToOne
	@JoinColumn(name = "ID_CLASIFICACION", referencedColumnName = "ID_CLASIFICACION")
	private Clasificacion idClasificacion;
	@ManyToOne
	@JoinColumn(name = "ID_TIPO_TRATAMIENTO", referencedColumnName = "ID_TIPO_TRATAMIENTO")
	private TipoTratamiento idTipoTratamiento;
	@Column(name = "APLICA")
	private boolean aplica;
	@ManyToOne
	@JoinColumn(name = "ID_ARQUITECTURA", referencedColumnName = "ID_ARQUITECTURA")
	private ArquitecturaAplicacion idArquitectura;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "TRATAMIENTO_RIESGO", joinColumns = { @JoinColumn(name = "correlativo") }, inverseJoinColumns = { @JoinColumn(name = "id_solucion") })
	private Set<Solucion> soluciones = new HashSet<Solucion>();
	
	@Transient private Integer calificacion;
	@Transient private String nivel;
	@Transient private String nivelProbabilidad;
	@Transient private String nivelImpacto;

	public EvaluacionRiesgo() {
		// TODO Auto-generated constructor stub
	}
	
	public Set<Solucion> getSoluciones() {
		return soluciones;
	}
	
	public void setSoluciones(Set<Solucion> soluciones) {
		this.soluciones = soluciones;
	}
	
	public ArquitecturaAplicacion getIdArquitectura() {
		return idArquitectura;
	}
	
	public void setIdArquitectura(ArquitecturaAplicacion idArquitectura) {
		this.idArquitectura = idArquitectura;
	}
	
	public boolean isAplica() {
		return aplica;
	}
	
	public void setAplica(boolean aplica) {
		this.aplica = aplica;
	}
	
	public TipoTratamiento getIdTipoTratamiento() {
		return idTipoTratamiento;
	}
	
	public void setIdTipoTratamiento(TipoTratamiento idTipoTratamiento) {
		this.idTipoTratamiento = idTipoTratamiento;
	}
	
	public String getNivelImpacto() {
		return nivelImpacto;
	}
	public void setNivelImpacto(String nivelImpacto) {
		this.nivelImpacto = nivelImpacto;
	}
	public String getNivelProbabilidad() {
		return nivelProbabilidad;
	}
	public void setNivelProbabilidad(String nivelProbabilidad) {
		this.nivelProbabilidad = nivelProbabilidad;
	}
	
	public Integer getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(Integer calificacion) {
		this.calificacion = calificacion;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Integer getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(Integer correlativo) {
		this.correlativo = correlativo;
	}

	public Riesgo getIdRiesgo() {
		return idRiesgo;
	}

	public void setIdRiesgo(Riesgo idRiesgo) {
		this.idRiesgo = idRiesgo;
	}

	public Integer getProbabilidad() {
		return probabilidad;
	}

	public void setProbabilidad(Integer probabilidad) {
		this.probabilidad = probabilidad;
	}

	public Integer getImpacto() {
		return impacto;
	}

	public void setImpacto(Integer impacto) {
		this.impacto = impacto;
	}

	public Activo getIdActivo() {
		return idActivo;
	}

	public void setIdActivo(Activo idActivo) {
		this.idActivo = idActivo;
	}

	public Clasificacion getIdClasificacion() {
		return idClasificacion;
	}

	public void setIdClasificacion(Clasificacion idClasificacion) {
		this.idClasificacion = idClasificacion;
	}
	
	
}
