/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.seguridad.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gt.seguridad.model.Usuario;

/**
 *
 * @author ejmorales
 */
@Repository
public interface UserRepository extends JpaRepository<Usuario, Serializable>{
    
    @Query(value = "SELECT u FROM Usuario u WHERE UPPER(u.usuario) = UPPER(:usuario) AND u.estado = 1 ", nativeQuery = false)
    public Usuario findByLogin(@Param("usuario") String usuario);
    
}
