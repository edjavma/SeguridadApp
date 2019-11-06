package gt.seguridad.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gt.seguridad.model.riesgo.ClasificacionRiesgo;
import gt.seguridad.model.riesgo.Riesgo;
import gt.seguridad.repository.riesgo.ClasificacionRiesgoRepository;
import gt.seguridad.repository.riesgo.RiesgoRepository;
import gt.seguridad.service.impl.IRiesgoService;

@Service
public class RiesgoService implements IRiesgoService {

	@Autowired
	private RiesgoRepository riesgoRepository;
	
	@Autowired
	private ClasificacionRiesgoRepository clasificacionRiesgoRepository;

	@Override
	public List<Riesgo> listRiesgos() {
		try {
			List<Riesgo> riesgos = riesgoRepository
					.findAll(new Sort(Sort.Direction.ASC, "idRiesgoCapa.idRiesgoCapa", "idTipoRiesgo.idTipoRiesgo",
							"idTipoImpacto.idTipoImpacto", "idTipoBrecha.idTipoBrecha"));

			int count = 1;
			for (Riesgo riesgo : riesgos) {
				riesgo.setId(count);
				if (count < 10) {
					riesgo.setIdentificador("R-00" + count);
				} else if (count < 100) {
					riesgo.setIdentificador("R-0" + count);
				}
				count++;
			}

			return riesgos;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@Override
	public List<Riesgo> notEvaluated(Integer selectedArq) {
		try {
			return riesgoRepository.findNonEval(selectedArq);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ArrayList<>();
	}

	@Override
	public Riesgo findRiesgo(Integer idRiesgo) {
		try {
			return riesgoRepository.findOne(idRiesgo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void save(Riesgo riesgo) throws Exception {
		try {
			Long id = riesgoRepository.getId();
			if (riesgo.getIdRiesgo() == null)
				riesgo.setIdRiesgo(id.intValue());
			riesgoRepository.save(riesgo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public void delete(Riesgo riesgo) throws Exception {
		try {
			riesgoRepository.delete(riesgo);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<ClasificacionRiesgo> listClasificacionesRiesgo() {
		try {
			return clasificacionRiesgoRepository.findAll(new Sort(Sort.Direction.ASC,"idClasificacionRiesgo"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ArrayList<>();
	}

	@Override
	public ClasificacionRiesgo getClasificacion(String tipo, Integer value) {
		try {
			if(tipo.equalsIgnoreCase("single")) {
				return clasificacionRiesgoRepository.findOne(value);
			}else if(tipo.equalsIgnoreCase("calc")){
				return clasificacionRiesgoRepository.getClasificacionRiesgo(value);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
