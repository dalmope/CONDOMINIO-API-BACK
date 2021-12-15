/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.API.datos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.API.security.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author David Alberto Mora Peñaranda
 */
@Entity
@Table(name = "espacio")
@NamedQueries({
        @NamedQuery(name = "Espacio.findAll", query = "SELECT e FROM Espacio e"),
        @NamedQuery(name = "Espacio.findById", query = "SELECT e FROM Espacio e WHERE e.id = :id"),
        @NamedQuery(name = "Espacio.findByUbicacion", query = "SELECT e FROM Espacio e WHERE e.ubicacion = :ubicacion"),
        @NamedQuery(name = "Espacio.findByFecha", query = "SELECT e FROM Espacio e WHERE e.fecha = :fecha") })
public class Espacio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JsonIgnore
    @ManyToMany(mappedBy = "espacioSet")
    private Set<Usuario> usuarioSet;
    @JoinTable(name = "estado_estadoespacio", joinColumns = {
            @JoinColumn(name = "id_espacio", referencedColumnName = "ID") }, inverseJoinColumns = {
                    @JoinColumn(name = "id_estado", referencedColumnName = "ID") })
    @ManyToMany
    private Set<EstadoEspacio> estadoEspacioSet;

    public Espacio() {
    }

    public Espacio(Integer id) {
        this.id = id;
    }

    public Espacio(Integer id, String ubicacion, Date fecha) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Usuario> getUsuarioSet() {
        return usuarioSet;
    }

    public void setUsuarioSet(Set<Usuario> usuarioSet) {
        this.usuarioSet = usuarioSet;
    }

    public Set<EstadoEspacio> getEstadoEspacioSet() {
        return estadoEspacioSet;
    }

    public void setEstadoEspacioSet(Set<EstadoEspacio> estadoEspacioSet) {
        this.estadoEspacioSet = estadoEspacioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Espacio)) {
            return false;
        }
        Espacio other = (Espacio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.newpackage.Espacio[ id=" + id + " ]";
    }

}
