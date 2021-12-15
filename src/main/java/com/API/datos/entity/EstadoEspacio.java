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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author David Alberto Mora Peñaranda
 */
@Entity
@Table(name = "estado_espacio")
@NamedQueries({
    @NamedQuery(name = "EstadoEspacio.findAll", query = "SELECT e FROM EstadoEspacio e"),
    @NamedQuery(name = "EstadoEspacio.findById", query = "SELECT e FROM EstadoEspacio e WHERE e.id = :id"),
    @NamedQuery(name = "EstadoEspacio.findByEstado", query = "SELECT e FROM EstadoEspacio e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoEspacio.findByFecha", query = "SELECT e FROM EstadoEspacio e WHERE e.fecha = :fecha")})
public class EstadoEspacio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JsonIgnore
    @ManyToMany(mappedBy = "estadoEspacioSet")
    private Set<Espacio> espacioSet;

    public EstadoEspacio() {
    }

    public EstadoEspacio(Integer id) {
        this.id = id;
    }

    public EstadoEspacio(Integer id, String estado, Date fecha) {
        this.id = id;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Espacio> getEspacioSet() {
        return espacioSet;
    }

    public void setEspacioSet(Set<Espacio> espacioSet) {
        this.espacioSet = espacioSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EstadoEspacio)) {
            return false;
        }
        EstadoEspacio other = (EstadoEspacio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.newpackage.EstadoEspacio[ id=" + id + " ]";
    }
    
}
