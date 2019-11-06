package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.RiesgoCapa;

@Repository
public interface RiesgoCapaRepository extends JpaRepository<RiesgoCapa, Serializable>{
	
	@Query(value = "SELECT NVL(MAX(ID_RIESGO_CAPA),0) + 1 FROM RIESGO_CAPA", nativeQuery = true)
	public Long getId();

}
