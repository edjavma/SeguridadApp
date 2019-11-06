package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.Activo;

@Repository
public interface ActivoRepository extends JpaRepository<Activo, Serializable>{

	@Query(value = "SELECT NVL(MAX(ID_ACTIVO),0) + 1 FROM ACTIVO", nativeQuery = true)
	public Long getId();
}
