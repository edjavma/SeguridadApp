package gt.seguridad.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
import gt.seguridad.repository.catalogos.ActivoRepository;
import gt.seguridad.repository.catalogos.ArquitecturaAplicacionRepository;
import gt.seguridad.repository.catalogos.ClasificacionRepository;
import gt.seguridad.repository.catalogos.GeneradorRiesgoRepository;
import gt.seguridad.repository.catalogos.ResponsableRepository;
import gt.seguridad.repository.catalogos.RiesgoCapaRepository;
import gt.seguridad.repository.catalogos.SolucionRepository;
import gt.seguridad.repository.catalogos.TipoBrechaRepository;
import gt.seguridad.repository.catalogos.TipoImpactoRepository;
import gt.seguridad.repository.catalogos.TipoRiesgoRepository;
import gt.seguridad.repository.catalogos.TipoTratamientoRepository;
import gt.seguridad.service.impl.IGeneralService;

@Service
public class GeneralService implements IGeneralService{
	
	@Autowired
	private ActivoRepository activoRepository;
	@Autowired
	private ArquitecturaAplicacionRepository arquitecturaAplicacionRepository;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GeneralService.class);
	
	@Override
	public List<Activo> listActivos() {
		try {
			return activoRepository.findAll(new Sort(Sort.Direction.DESC, "idActivo"));
		} catch (Exception e) {
			LOGGER.error("listActivos", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<ArquitecturaAplicacion> listArquitecturas() {
		try {
			return arquitecturaAplicacionRepository.findAll(new Sort(Sort.Direction.DESC, "idArquitectura"));
		} catch (Exception e) {
			LOGGER.error("listArquitecturas", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Clasificacion> listClasificaciones() {
		try {
			return clasificacionRepository.findAll(new Sort(Sort.Direction.DESC, "idClasificacion"));
		} catch (Exception e) {
			LOGGER.error("listClasificaciones", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<GeneradorRiesgo> listGeneradorRiesgo() {
		try {
			return generadorRiesgoRepository.findAll(new Sort(Sort.Direction.DESC, "idGeneradorRiesgo"));
		} catch (Exception e) {
			LOGGER.error("listGeneradorRiesgo", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Responsable> listResponsable() {
		try {
			return responsableRepository.findAll(new Sort(Sort.Direction.DESC, "idResponsable"));
		} catch (Exception e) {
			LOGGER.error("listResponsable", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<TipoBrecha> listTipoBrecha() {
		try {
			return tipoBrechaRepository.findAll(new Sort(Sort.Direction.DESC, "idTipoBrecha"));
		} catch (Exception e) {
			LOGGER.error("listTipoBrecha", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<TipoDeRiesgo> listTipoRiesgo() {
		try {
			return tipoRiesgoRepository.findAll(new Sort(Sort.Direction.DESC, "idTipoRiesgo"));
		} catch (Exception e) {
			LOGGER.error("listTipoRiesgo", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<TipoImpacto> listTipoImpacto() {
		try {
			return tipoImpactoRepository.findAll(new Sort(Sort.Direction.DESC, "idTipoImpacto"));
		} catch (Exception e) {
			LOGGER.error("listTipoImpacto", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<TipoTratamiento> listTipoTratamiento() {
		try {
			return tipoTratamientoRepository.findAll(new Sort(Sort.Direction.DESC, "idTipoTratamiento"));
		} catch (Exception e) {
			LOGGER.error("listTipoTratamiento", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<RiesgoCapa> listRiesgoCapa() {
		try {
			return riesgoCapaRepository.findAll(new Sort(Sort.Direction.DESC, "idRiesgoCapa"));
		} catch (Exception e) {
			LOGGER.error("listRiesgoCapa", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Solucion> listSolucion() {
		try {
			return solucionRepository.findAll(new Sort(Sort.Direction.DESC, "idSolucion"));
		} catch (Exception e) {
			LOGGER.error("listSolucion", e);
		}
		
		return new ArrayList<>();
	}
	
	

}
