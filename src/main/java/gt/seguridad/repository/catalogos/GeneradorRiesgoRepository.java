package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.GeneradorRiesgo;

@Repository
public interface GeneradorRiesgoRepository extends JpaRepository<GeneradorRiesgo, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_GENERADOR_RIESGO),0) + 1 FROM GENERADOR_RIESGO", nativeQuery = true)
	public Long getId();
}
