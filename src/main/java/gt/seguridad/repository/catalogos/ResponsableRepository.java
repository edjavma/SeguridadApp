package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.Responsable;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_RESPONSABLE),0) + 1 FROM RESPONSABLE", nativeQuery = true)
	public Long getId();
}
