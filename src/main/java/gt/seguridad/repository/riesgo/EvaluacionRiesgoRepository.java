package gt.seguridad.repository.riesgo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.riesgo.EvaluacionRiesgo;
import gt.seguridad.pojo.Data;

@Repository
public interface EvaluacionRiesgoRepository extends JpaRepository<EvaluacionRiesgo, Serializable>{

	
	@Query(value = "SELECT NVL(MAX(CORRELATIVO),0) + 1 FROM EVALUACION_RIESGO", nativeQuery = true)
	public Long getId();
	
	@Query(value = "SELECT u FROM EvaluacionRiesgo u WHERE u.idRiesgo.idRiesgo = :idRiesgo", nativeQuery = false)
	public EvaluacionRiesgo findByIdRiesgo(@Param("idRiesgo") Integer idRiesgo);
	
	//public List<EvaluacionRiesgo> findByAplicaTrue(Sort sort);
	
	@Query(value = "SELECT E.* FROM EVALUACION_RIESGO E " +
				   "INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO "+
			       "WHERE E.ID_ARQUITECTURA = ?1 "+
				   "AND E.APLICA = 1 "+
				   "ORDER BY R.ID_RIESGO_CAPA, R.ID_TIPO_RIESGO, R.ID_TIPO_IMPACTO, R.ID_TIPO_BRECHA ", nativeQuery = true)
	public List<EvaluacionRiesgo> listAllByArq(Integer idArquitectura);
	
	@Query(value = "SELECT E.* FROM EVALUACION_RIESGO E " +
			   "INNER JOIN RIESGO R ON E.ID_RIESGO = R.ID_RIESGO "+
			   "AND E.APLICA = 1 "+
			   "ORDER BY R.ID_RIESGO_CAPA, R.ID_TIPO_RIESGO, R.ID_TIPO_IMPACTO, R.ID_TIPO_BRECHA ", nativeQuery = true)
	public List<EvaluacionRiesgo> listAll();
	
	public List<Data> getInfoDashboardRiesgo(String idArquitectura);
	public List<Data> getInfoDashboardImpacto(String idArquitectura);
	public List<Data> getInfoDashboardBrecha(String idArquitectura);
	public List<Data> getInfoDashboardTratamiento(String idArquitectura);
}
