package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.TipoImpacto;

@Repository
public interface TipoImpactoRepository extends JpaRepository<TipoImpacto, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_TIPO_IMPACTO),0) + 1 FROM TIPO_DE_IMPACTO", nativeQuery = true)
	public Long getId();
}
