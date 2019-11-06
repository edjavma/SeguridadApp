package gt.seguridad.model.riesgo;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import gt.seguridad.pojo.MapaRiesgo;

@Entity
@NamedNativeQueries({
	@NamedNativeQuery(name = "ClasificacionRiesgo.getDataMapa",
			query = "SELECT R.ID_CLASIFICACION_RIESGO, R.NOMBRE,     " + 
					"PKG_DASHBOARD.OBTENER_VALOR_MAPA(R.ID_CLASIFICACION_RIESGO, 1, ?1) BAJO,    " + 
					"PKG_DASHBOARD.OBTENER_VALOR_MAPA(R.ID_CLASIFICACION_RIESGO, 2, ?1) MEDIO,    " + 
					"PKG_DASHBOARD.OBTENER_VALOR_MAPA(R.ID_CLASIFICACION_RIESGO, 3, ?1) ALTO,    " + 
					"PKG_DASHBOARD.OBTENER_VALOR_MAPA(R.ID_CLASIFICACION_RIESGO, 4, ?1) CRITICO,    " + 
					"PKG_DASHBOARD.OBTENER_CLASIFICACION_RIESGO_T(R.ID_CLASIFICACION_RIESGO * 1) COLOR_A,    " + 
					"PKG_DASHBOARD.OBTENER_CLASIFICACION_RIESGO_T(R.ID_CLASIFICACION_RIESGO * 2) COLOR_B,    " + 
					"PKG_DASHBOARD.OBTENER_CLASIFICACION_RIESGO_T(R.ID_CLASIFICACION_RIESGO * 3) COLOR_C,    " + 
					"PKG_DASHBOARD.OBTENER_CLASIFICACION_RIESGO_T(R.ID_CLASIFICACION_RIESGO * 4) COLOR_D       " + 
					"FROM CLASIFICACION_RIESGO R    " + 
					"ORDER BY ID_CLASIFICACION_RIESGO DESC",
			resultSetMapping = "ResultsClasificacionRiesgo")
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name = "ResultsClasificacionRiesgo",
			classes = {
					@ConstructorResult(targetClass = MapaRiesgo.class,
							columns = {
									@ColumnResult(name = "ID_CLASIFICACION_RIESGO",type = Integer.class),
									@ColumnResult(name = "NOMBRE",type = String.class),
									@ColumnResult(name = "BAJO",type = Integer.class),
									@ColumnResult(name = "MEDIO",type = Integer.class),
									@ColumnResult(name = "ALTO",type = Integer.class),
									@ColumnResult(name = "CRITICO",type = Integer.class),
									@ColumnResult(name = "COLOR_A",type = String.class),
									@ColumnResult(name = "COLOR_B",type = String.class),
									@ColumnResult(name = "COLOR_C",type = String.class),
									@ColumnResult(name = "COLOR_D",type = String.class),
							})
			})
})
@Table(name = "CLASIFICACION_RIESGO")
public class ClasificacionRiesgo {

	@Id
	@Column(name = "ID_CLASIFICACION_RIESGO")
	private Integer idClasificacionRiesgo;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "INIT_VALUE")
	private Integer initValue;
	@Column(name = "FINAL_VALUE")
	private Integer finalValue;
	
	public ClasificacionRiesgo() {
		// TODO Auto-generated constructor stub
	}

	public Integer getIdClasificacionRiesgo() {
		return idClasificacionRiesgo;
	}

	public void setIdClasificacionRiesgo(Integer idClasificacionRiesgo) {
		this.idClasificacionRiesgo = idClasificacionRiesgo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getInitValue() {
		return initValue;
	}

	public void setInitValue(Integer initValue) {
		this.initValue = initValue;
	}

	public Integer getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(Integer finalValue) {
		this.finalValue = finalValue;
	}
	
	
}
