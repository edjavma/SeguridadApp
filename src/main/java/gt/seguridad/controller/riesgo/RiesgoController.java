package gt.seguridad.controller.riesgo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gt.seguridad.model.riesgo.ClasificacionRiesgo;
import gt.seguridad.model.riesgo.EvaluacionRiesgo;
import gt.seguridad.model.riesgo.Riesgo;
import gt.seguridad.service.EvaluacionRiesgoService;
import gt.seguridad.service.RiesgoService;
import gt.seguridad.utils.ResponseData;
import gt.seguridad.utils.UrlPath;

@RestController
@RequestMapping(value = UrlPath.RIESGO)
public class RiesgoController {

	@Autowired
	private RiesgoService riesgoService;
	
	@Autowired
	private EvaluacionRiesgoService evaluacionRiesgoService;
	
	@RequestMapping(value = UrlPath.LIST_CLASIFICACION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<ClasificacionRiesgo> listClasificaciones(){
		return riesgoService.listClasificacionesRiesgo();
	}

	
	@RequestMapping(value = UrlPath.CLASIFICACION, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ClasificacionRiesgo getClasificacion(@RequestParam("tipo") String tipo, @RequestParam("value") Integer value) {
		return riesgoService.getClasificacion(tipo, value);
	}

	@RequestMapping(value = UrlPath.LISTAR, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Riesgo> listRiesgos() {
		return riesgoService.listRiesgos();
	}

	@RequestMapping(value = UrlPath.NO_EVALUADOS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Riesgo> notEvaluated(@RequestParam("selectedArq") Integer selectedArq) {
		return riesgoService.notEvaluated(selectedArq);
	}

	@RequestMapping(value = UrlPath.FIND, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData<Riesgo> findRiesgo(@RequestParam("idRiesgo") Integer idRiesgo) {
		ResponseData<Riesgo> response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			
			response = new ResponseData<>(HttpStatus.OK);
			response.setData(riesgoService.findRiesgo(idRiesgo));
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.GUARDAR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody Riesgo riesgo) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			riesgoService.save(riesgo);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData delete(@RequestBody Riesgo riesgo) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			EvaluacionRiesgo eval = evaluacionRiesgoService.findEvaluacionByRiesgo(riesgo.getIdRiesgo());
			
			if(eval == null) {
				riesgoService.delete(riesgo);
				response = new ResponseData<>(HttpStatus.OK);				
			}else {
				response.setMessage("No puede eliminar el riesgo, debe eliminar primero la evaluacion para el mismo.");
			}
			

		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	
}
