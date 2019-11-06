package gt.seguridad.controller.riesgo;

import java.io.ByteArrayOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.riesgo.TratamientoRiesgo;
import gt.seguridad.pojo.PickList;
import gt.seguridad.service.TratamientoRiesgoService;
import gt.seguridad.utils.ResponseData;
import gt.seguridad.utils.UrlPath;

@RestController
@RequestMapping(value = UrlPath.TRATAMIENTO_RIESGO)
public class TratamientoController {
	
	@Autowired
	private TratamientoRiesgoService tratamientoRiesgoService;
	
	
	@RequestMapping(value = UrlPath.PICK_LIST, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PickList<Solucion> save(@RequestParam("correlativo") Integer correlativo) throws Exception {
		PickList<Solucion> response = new PickList<>();
		try {
			response.setSource(tratamientoRiesgoService.listTratamientosSource(correlativo));
			response.setTarget(tratamientoRiesgoService.listTratamientosTarget(correlativo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.SAVE_PICK_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody PickList<Solucion> data) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			tratamientoRiesgoService.save(data);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.GUARDAR, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData save(@RequestBody TratamientoRiesgo tratamiento) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			tratamientoRiesgoService.save(tratamiento);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
		
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = UrlPath.DELETE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseData delete(@RequestBody TratamientoRiesgo tratamiento) throws Exception {
		ResponseData response = new ResponseData<>(HttpStatus.BAD_REQUEST);
		try {
			tratamientoRiesgoService.delete(tratamiento);
			response = new ResponseData<>(HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseData<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> responseDocumentEvaluacion() {
		try {
			ByteArrayOutputStream baos = tratamientoRiesgoService.document();
			
			if(baos != null) {
				
				HttpHeaders headers = new HttpHeaders();
				headers.set("Content-disposition", "filename=tratamiento_riesgo_grupo4.xlsx");
				
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
