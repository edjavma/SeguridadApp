/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.seguridad.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author ejmorales
 */
@Entity
@Table(name = "PERFIL")
public class Perfil implements GrantedAuthority,Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "ID_PERFIL")
    private BigDecimal idPerfil;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private boolean estado;
    
    @JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "perfiles")
	private Set<Usuario> users = new HashSet<Usuario>();

	/*@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "perfil_opcion", joinColumns = { @JoinColumn(name = "perfil_id") }, inverseJoinColumns = { @JoinColumn(name = "opcion_id") })
	@WhereJoinTable(clause="ESTATUS='A'")
	private Set<Opcion> opss = new HashSet<Opcion>();*/

    public Perfil() {
    }

    public Perfil(BigDecimal idPerfil, String nombre, String descripcion, boolean estado) {
        this.idPerfil = idPerfil;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Set<Usuario> getUsers() {
        return users;
    }

    public void setUsers(Set<Usuario> users) {
        this.users = users;
    }
    
    

    public BigDecimal getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(BigDecimal idPerfil) {
        this.idPerfil = idPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String getAuthority() {
        return nombre;
    }
    
    
    
    
    
}
