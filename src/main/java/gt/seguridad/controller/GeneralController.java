package gt.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import gt.seguridad.service.GeneralService;
import gt.seguridad.service.impl.IGeneralService;
import gt.seguridad.utils.UrlPath;

@RestController
@RequestMapping(value = UrlPath.GENERALES)
public class GeneralController implements IGeneralService{
	
	@Autowired
	private GeneralService generalService;

	@Override
	@RequestMapping(value = UrlPath.ACTIVO, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Activo> listActivos() {
		return generalService.listActivos();
	}

	@Override
	@RequestMapping(value = UrlPath.ARQUITECTURA_APP, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ArquitecturaAplicacion> listArquitecturas() {
		return generalService.listArquitecturas();
	}

	@Override
	@RequestMapping(value = UrlPath.CLASIFICACION, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Clasificacion> listClasificaciones() {
		return generalService.listClasificaciones();
	}

	@Override
	@RequestMapping(value = UrlPath.GENERADOR_RIESGO, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<GeneradorRiesgo> listGeneradorRiesgo() {
		return generalService.listGeneradorRiesgo();
	}

	@Override
	@RequestMapping(value = UrlPath.RESPONSABLE, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Responsable> listResponsable() {
		return generalService.listResponsable();
	}

	@Override
	@RequestMapping(value = UrlPath.TIPO_BRECHA, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TipoBrecha> listTipoBrecha() {
		return generalService.listTipoBrecha();
	}

	@Override
	@RequestMapping(value = UrlPath.TIPO_RIESGO, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TipoDeRiesgo> listTipoRiesgo() {
		return generalService.listTipoRiesgo();
	}

	@Override
	@RequestMapping(value = UrlPath.TIPO_IMPACTO, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TipoImpacto> listTipoImpacto() {
		return generalService.listTipoImpacto();
	}

	@Override
	@RequestMapping(value = UrlPath.TIPO_TRATAMIENTO, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TipoTratamiento> listTipoTratamiento() {
		return generalService.listTipoTratamiento();
	}

	@Override
	@RequestMapping(value = UrlPath.RIESGO_CAPA, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<RiesgoCapa> listRiesgoCapa() {
		return generalService.listRiesgoCapa();
	}

	@Override
	@RequestMapping(value = UrlPath.SOLUCION, method = RequestMethod.GET,
	produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Solucion> listSolucion() {
		return generalService.listSolucion();
	}
	
	

}
