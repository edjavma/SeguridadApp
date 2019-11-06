package gt.seguridad.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import gt.seguridad.model.riesgo.EvaluacionRiesgo;

public interface IEvaluacionService {
	public List<EvaluacionRiesgo> listEvaluaciones(Integer selectedArq);
	public List<EvaluacionRiesgo> listEvaluadosAplica(Integer selectedArq);
	public EvaluacionRiesgo findEvaluacion(Integer idEvaluacionRiesgo);
	public EvaluacionRiesgo findEvaluacionByRiesgo(Integer idRiesgo);
	public void save(EvaluacionRiesgo evaluacion) throws Exception;	
	public void delete(EvaluacionRiesgo evaluacion) throws Exception;
	
	public ByteArrayOutputStream document() throws Exception;
}
