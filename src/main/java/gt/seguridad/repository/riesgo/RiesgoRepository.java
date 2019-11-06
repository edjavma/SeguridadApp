package gt.seguridad.repository.riesgo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.riesgo.Riesgo;

@Repository
public interface RiesgoRepository extends JpaRepository<Riesgo, Serializable>{

	@Query(value = "SELECT NVL(MAX(ID_RIESGO),0) + 1 FROM RIESGO", nativeQuery = true)
	public Long getId();
	
	public List<Riesgo> findNonEval(Integer selectedArq);
}
