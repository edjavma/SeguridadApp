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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.WhereJoinTable;

/**
 *
 * @author ejmorales
 */
@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "ID_USUARIO")
    private BigDecimal idUsuario;
    @Column(name = "USUARIO")
    private String usuario;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ESTADO")
    private boolean estado;
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "perfil_usuario", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = { @JoinColumn(name = "id_perfil") })
    @WhereJoinTable(clause="ESTADO=1")
    private Set<Perfil> perfiles = new HashSet<Perfil>();

    public Usuario(Usuario usuario){
        super();
        this.idUsuario = usuario.getIdUsuario();
        this.usuario = usuario.getUsuario();
        this.password = usuario.getPassword();
        this.estado = usuario.isEstado();
                
    }
    
    public Usuario() {
    }

    public Usuario(BigDecimal idUsuario, String usuario, String password, boolean estado) {
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
    }

    public Set<Perfil> getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(Set<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
    
    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}
