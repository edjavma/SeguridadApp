package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.TipoBrecha;

@Repository
public interface TipoBrechaRepository extends JpaRepository<TipoBrecha, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_TIPO_BRECHA),0) + 1 FROM TIPO_DE_BRECHA", nativeQuery = true)
	public Long getId();
}
