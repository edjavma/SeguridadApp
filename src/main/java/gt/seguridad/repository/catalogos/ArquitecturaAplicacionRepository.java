package gt.seguridad.repository.catalogos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.catalogos.ArquitecturaAplicacion;

@Repository
public interface ArquitecturaAplicacionRepository extends JpaRepository<ArquitecturaAplicacion, Serializable>{

}
