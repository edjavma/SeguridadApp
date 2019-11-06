package gt.seguridad.repository.riesgo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.riesgo.ClasificacionRiesgo;
import gt.seguridad.pojo.MapaRiesgo;

@Repository
public interface ClasificacionRiesgoRepository extends JpaRepository<ClasificacionRiesgo, Serializable>{

	@Query(value = "SELECT * FROM CLASIFICACION_RIESGO WHERE ? BETWEEN INIT_VALUE AND FINAL_VALUE", nativeQuery = true)
	public ClasificacionRiesgo getClasificacionRiesgo(Integer value);
	
	public List<MapaRiesgo> getDataMapa(String arquitectura);
}
