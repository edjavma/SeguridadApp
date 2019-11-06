package gt.seguridad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import gt.seguridad.service.GeneralAddService;
import gt.seguridad.utils.ResponseData;
import gt.seguridad.utils.UrlPath;

@RestController
@RequestMapping(value = UrlPath.GENERALES_ADD)
public class GeneralAddController {

	@Autowired
	private GeneralAddService generalAddService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.ACTIVO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody Activo data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.CLASIFICACION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody Clasificacion data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.GENERADOR_RIESGO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody GeneradorRiesgo data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.RESPONSABLE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody Responsable data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.TIPO_BRECHA, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody TipoBrecha data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.TIPO_RIESGO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody TipoDeRiesgo data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.TIPO_IMPACTO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody TipoImpacto data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.TIPO_TRATAMIENTO, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody TipoTratamiento data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.RIESGO_CAPA, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody RiesgoCapa data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.SOLUCION, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody Solucion data) {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			generalAddService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

}
