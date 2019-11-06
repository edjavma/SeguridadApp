package gt.seguridad.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
import gt.seguridad.repository.catalogos.ActivoRepository;
import gt.seguridad.repository.catalogos.ClasificacionRepository;
import gt.seguridad.repository.catalogos.GeneradorRiesgoRepository;
import gt.seguridad.repository.catalogos.ResponsableRepository;
import gt.seguridad.repository.catalogos.RiesgoCapaRepository;
import gt.seguridad.repository.catalogos.SolucionRepository;
import gt.seguridad.repository.catalogos.TipoBrechaRepository;
import gt.seguridad.repository.catalogos.TipoImpactoRepository;
import gt.seguridad.repository.catalogos.TipoRiesgoRepository;
import gt.seguridad.repository.catalogos.TipoTratamientoRepository;
import gt.seguridad.service.impl.IGeneralAddService;

@Service
public class GeneralAddService implements IGeneralAddService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GeneralAddService.class);

	@Autowired
	private ActivoRepository activoRepository;	
	@Autowired
	private ClasificacionRepository clasificacionRepository;	
	@Autowired
	private GeneradorRiesgoRepository generadorRiesgoRepository;
	@Autowired
	private ResponsableRepository responsableRepository;
	@Autowired
	private TipoBrechaRepository tipoBrechaRepository;
	@Autowired
	private TipoImpactoRepository tipoImpactoRepository;
	@Autowired
	private TipoRiesgoRepository tipoRiesgoRepository;
	@Autowired
	private TipoTratamientoRepository tipoTratamientoRepository;
	@Autowired
	private RiesgoCapaRepository riesgoCapaRepository;
	@Autowired
	private SolucionRepository solucionRepository;
	
	@Override
	public void save(Activo data) throws Exception {
		try {
			Long id = activoRepository.getId();
			data.setIdActivo(id.intValue());
			activoRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(Clasificacion data) throws Exception {
		try {
			Long id = clasificacionRepository.getId();
			data.setIdClasificacion(id.intValue());
			clasificacionRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(GeneradorRiesgo data) throws Exception {
		try {
			Long id = generadorRiesgoRepository.getId();
			data.setIdGeneradorRiesgo(id.intValue());
			generadorRiesgoRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(Responsable data) throws Exception {
		try {
			Long id = responsableRepository.getId();
			data.setIdResponsable(id.intValue());
			responsableRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(TipoBrecha data) throws Exception {
		try {
			Long id = tipoBrechaRepository.getId();
			data.setIdTipoBrecha(id.intValue());
			tipoBrechaRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(TipoDeRiesgo data) throws Exception {
		try {
			Long id = tipoRiesgoRepository.getId();
			data.setIdTipoRiesgo(id.intValue());
			tipoRiesgoRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(TipoImpacto data) throws Exception {
		try {
			Long id = tipoImpactoRepository.getId();
			data.setIdTipoImpacto(id.intValue());
			tipoImpactoRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(TipoTratamiento data) throws Exception {
		try {
			Long id = tipoTratamientoRepository.getId();
			data.setIdTipoTratamiento(id.intValue());
			tipoTratamientoRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(RiesgoCapa data) throws Exception {
		try {
			Long id = riesgoCapaRepository.getId();
			data.setIdRiesgoCapa(id.intValue());
			riesgoCapaRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void save(Solucion data) throws Exception {
		try {
			Long id = solucionRepository.getId();
			data.setIdSolucion(id.intValue());
			solucionRepository.save(data);
		} catch (Exception e) {
			LOGGER.error("save: ", e);
			throw new Exception(e.getMessage());
		}
	}

}
