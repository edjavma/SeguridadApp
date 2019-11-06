package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.TipoTratamiento;

@Repository
public interface TipoTratamientoRepository extends JpaRepository<TipoTratamiento, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_TIPO_TRATAMIENTO),0) + 1 FROM TIPO_DE_TRATAMIENTO", nativeQuery = true)
	public Long getId();
}
