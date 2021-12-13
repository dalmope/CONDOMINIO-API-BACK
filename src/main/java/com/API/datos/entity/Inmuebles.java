/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.API.datos.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.API.security.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 *
 * @author David Alberto Mora Peñaranda
 */
@Entity
@Table(name = "inmuebles")
@NamedQueries({
    @NamedQuery(name = "Inmuebles.findAll", query = "SELECT i FROM Inmuebles i"),
    @NamedQuery(name = "Inmuebles.findById", query = "SELECT i FROM Inmuebles i WHERE i.id = :id"),
    @NamedQuery(name = "Inmuebles.findByDireccion", query = "SELECT i FROM Inmuebles i WHERE i.direccion = :direccion")})
public class Inmuebles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Basic(optional = false)
    @Column(name = "direccion", nullable = false, length = 255)
    private String direccion;
    @JoinTable(name = "estado_estadoinmueble", joinColumns = {
        @JoinColumn(name = "id_estadoInmueble", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "id_inmueble", referencedColumnName = "ID")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<EstadoInmueble> estadoInmuebleList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idInmueble")
    private List<Cuenta> cuentaList;
    @JoinColumn(name = "id_usuario", referencedColumnName = "ID")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario idUsuario;

    public Inmuebles() {
    }

    public Inmuebles(Integer id) {
        this.id = id;
    }

    public Inmuebles(String direccion) {
        this.direccion = direccion;
    }

    public Inmuebles(Integer id, String direccion) {
        this.id = id;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<EstadoInmueble> getEstadoInmuebleList() {
        return estadoInmuebleList;
    }

    public void setEstadoInmuebleList(Set<EstadoInmueble> estadoInmuebleList) {
        this.estadoInmuebleList = estadoInmuebleList;
    }

    @JsonManagedReference(value = "inmueble_cuenta")
    public List<Cuenta> getCuentaList() {
        return cuentaList;
    }

    public void setCuentaList(List<Cuenta> cuentaList) {
        this.cuentaList = cuentaList;
    }

    @JsonBackReference(value = "inmueble_usuario")
    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inmuebles)) {
            return false;
        }
        Inmuebles other = (Inmuebles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.newpackage.Inmuebles[ id=" + id + " ]";
    }
    
}
