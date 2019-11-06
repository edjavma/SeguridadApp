package gt.seguridad.service.impl;

import java.io.ByteArrayOutputStream;
import java.util.List;

import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.riesgo.TratamientoRiesgo;
import gt.seguridad.pojo.PickList;

public interface ITratamientoService {
	public List<Solucion> listTratamientosTarget(Integer correlativo);
	public List<Solucion> listTratamientosSource(Integer correlativo);
	public void save(PickList<Solucion> data) throws Exception;
	public void save(TratamientoRiesgo tratamiento) throws Exception;	
	public void delete(TratamientoRiesgo tratamiento) throws Exception;
	
	public ByteArrayOutputStream document() throws Exception;
}
