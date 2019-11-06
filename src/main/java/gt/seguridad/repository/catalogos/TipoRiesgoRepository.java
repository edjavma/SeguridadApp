package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.TipoDeRiesgo;

@Repository
public interface TipoRiesgoRepository extends JpaRepository<TipoDeRiesgo, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_TIPO_RIESGO),0) + 1 FROM TIPO_DE_RIESGO", nativeQuery = true)
	public Long getId();
}
