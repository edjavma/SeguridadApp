package gt.seguridad.service.impl;

import java.util.List;

import gt.seguridad.model.catalogos.Activo;
import gt.seguridad.model.catalogos.ArquitecturaAplicacion;
import gt.seguridad.model.catalogos.Clasificacion;
import gt.seguridad.model.catalogos.GeneradorRiesgo;
import gt.seguridad.model.catalogos.Responsable;
import gt.seguridad.model.catalogos.RiesgoCapa;
import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.catalogos.TipoBrecha;
import gt.seguridad.model.catalogos.TipoDeRiesgo;
import gt.seguridad.model.catalogos.TipoImpacto;
import gt.seguridad.model.catalogos.TipoTratamiento;

public interface IGeneralService {
	public List<Activo> listActivos();
	public List<ArquitecturaAplicacion> listArquitecturas();
	public List<Clasificacion> listClasificaciones();
	public List<GeneradorRiesgo> listGeneradorRiesgo();
	public List<Responsable> listResponsable();
	public List<TipoBrecha> listTipoBrecha();
	public List<TipoDeRiesgo> listTipoRiesgo();
	public List<TipoImpacto> listTipoImpacto();
	public List<TipoTratamiento> listTipoTratamiento();
	public List<RiesgoCapa> listRiesgoCapa();
	public List<Solucion> listSolucion();
}
