package gt.seguridad.service.impl;

import java.util.List;

import gt.seguridad.model.riesgo.ClasificacionRiesgo;
import gt.seguridad.model.riesgo.Riesgo;

public interface IRiesgoService {
	public List<Riesgo> listRiesgos();
	public List<Riesgo> notEvaluated(Integer selectedArq);
	public List<ClasificacionRiesgo> listClasificacionesRiesgo();
	public ClasificacionRiesgo getClasificacion(String tipo, Integer value);
	public Riesgo findRiesgo(Integer idRiesgo);
	public void save(Riesgo riesgo) throws Exception;	
	public void delete(Riesgo riesgo) throws Exception;
}
