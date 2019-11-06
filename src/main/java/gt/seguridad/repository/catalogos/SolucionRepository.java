package gt.seguridad.repository.catalogos;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.Solucion;

@Repository
public interface SolucionRepository extends JpaRepository<Solucion, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_SOLUCION),0) + 1 FROM SOLUCION", nativeQuery = true)
	public Long getId();
	
	@Query(value = "SELECT S.* FROM SOLUCION S INNER JOIN TRATAMIENTO_RIESGO T ON S.ID_SOLUCION = T.ID_SOLUCION WHERE T.CORRELATIVO = ?1 ", nativeQuery = true)
	public List<Solucion> listTratamientosTarget(Integer correlativo);
	
	@Query(value = "SELECT S.* FROM SOLUCION S WHERE NOT EXISTS (SELECT 1 FROM  TRATAMIENTO_RIESGO T WHERE T.CORRELATIVO = ?1 AND T.ID_SOLUCION = S.ID_SOLUCION) ", nativeQuery = true)
	public List<Solucion> listTratamientosSource(Integer correlativo);
}
