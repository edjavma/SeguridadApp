package gt.seguridad.service.impl;

import gt.seguridad.model.catalogos.Activo;
import gt.seguridad.model.catalogos.Clasificacion;
import gt.seguridad.model.catalogos.GeneradorRiesgo;
import gt.seguridad.model.catalogos.Responsable;
import gt.seguridad.model.catalogos.RiesgoCapa;
import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.catalogos.TipoBrecha;
import gt.seguridad.model.catalogos.TipoDeRiesgo;
import gt.seguridad.model.catalogos.TipoImpacto;
import gt.seguridad.model.catalogos.TipoTratamiento;

public interface IGeneralAddService {
	
	public void save(Activo data) throws Exception;
	public void save(Clasificacion data) throws Exception;
	public void save(GeneradorRiesgo data) throws Exception;
	public void save(Responsable data) throws Exception;
	public void save(TipoBrecha data) throws Exception;
	public void save(TipoDeRiesgo data) throws Exception;
	public void save(TipoImpacto data) throws Exception;
	public void save(TipoTratamiento data) throws Exception;
	public void save(RiesgoCapa data) throws Exception;
	public void save(Solucion data) throws Exception;
}
