package gt.seguridad.controller.riesgo;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gt.seguridad.model.riesgo.EvaluacionRiesgo;
import gt.seguridad.service.EvaluacionRiesgoService;
import gt.seguridad.utils.ResponseData;
import gt.seguridad.utils.UrlPath;

@RestController
@RequestMapping(value = UrlPath.EVALUACION)
public class EvaluacionController {
	
	@Autowired
	private EvaluacionRiesgoService evaluacionRiesgoService;
	
	@RequestMapping(value = UrlPath.LISTAR, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<EvaluacionRiesgo> listEvaluaciones(@RequestParam("selectedArq") Integer selectedArq) {
		return evaluacionRiesgoService.listEvaluaciones(selectedArq);
	}
	
	@RequestMapping(value = UrlPath.LISTAR_EVALUADOS, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<EvaluacionRiesgo> listEvaluados(@RequestParam("selectedArq") Integer selectedArq) {
		return evaluacionRiesgoService.listEvaluadosAplica(selectedArq);
	}
	
	@RequestMapping(value = UrlPath.FIND, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData<EvaluacionRiesgo> findEvaluacion(@RequestParam("idEvaluacion") Integer idEvaluacion) {
		ResponseData<EvaluacionRiesgo> response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			
			response = new ResponseData<>(HttpStatus.OK);
			response.setData(evaluacionRiesgoService.findEvaluacion(idEvaluacion));
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.GUARDAR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody EvaluacionRiesgo evaluacion) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			evaluacionRiesgoService.save(evaluacion);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData delete(@RequestBody EvaluacionRiesgo evaluacion) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			evaluacionRiesgoService.delete(evaluacion);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> responseDocumentEvaluacion() {
		try {
			ByteArrayOutputStream baos = evaluacionRiesgoService.document();
			
			if(baos != null) {
				
				HttpHeaders headers = new HttpHeaders();
				headers.set("Content-disposition", "filename=evaluacion_riesgo_grupo4.xlsx");
				
				return new ResponseEntity<byte[]>(baos.toByteArray(),headers,HttpStatus.OK);
			}else {
				return new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<byte[]>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
