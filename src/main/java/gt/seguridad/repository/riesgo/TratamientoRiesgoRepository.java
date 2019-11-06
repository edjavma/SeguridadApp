package gt.seguridad.repository.riesgo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.Solucion;
import gt.seguridad.model.riesgo.TratamientoRiesgo;

@Repository
public interface TratamientoRiesgoRepository extends JpaRepository<TratamientoRiesgo, Serializable>{
	@Query(value = "SELECT NVL(MAX(ID_TRATAMIENTO_RIESGO),0) + 1 FROM TRATAMIENTO_RIESGO", nativeQuery = true)
	public Long getId();
	
	/*@Modifying
	@Query("delete from TratamientoRiesgo d where d.correlativo.correlativo = :correlativo")
	public void deleteTratamientos(@Param("correlativo") Integer correlativo);*/
	
	@Query("SELECT u FROM TratamientoRiesgo u where u.correlativo.correlativo = :correlativo ")
	public List<TratamientoRiesgo> listByCorrelativo(@Param("correlativo") Integer correlativo);
}
