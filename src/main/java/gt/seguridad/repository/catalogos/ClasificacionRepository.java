package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.Clasificacion;

@Repository
public interface ClasificacionRepository extends JpaRepository<Clasificacion, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_CLASIFICACION),0) + 1 FROM CLASIFICACION", nativeQuery = true)
	public Long getId();
}
