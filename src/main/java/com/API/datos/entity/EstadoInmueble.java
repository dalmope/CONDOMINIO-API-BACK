/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.API.datos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "estado_inmueble")
@NamedQueries({
    @NamedQuery(name = "EstadoInmueble.findAll", query = "SELECT e FROM EstadoInmueble e"),
    @NamedQuery(name = "EstadoInmueble.findById", query = "SELECT e FROM EstadoInmueble e WHERE e.id = :id"),
    @NamedQuery(name = "EstadoInmueble.findByEstado", query = "SELECT e FROM EstadoInmueble e WHERE e.estado = :estado"),
    @NamedQuery(name = "EstadoInmueble.findByFecha", query = "SELECT e FROM EstadoInmueble e WHERE e.fecha = :fecha")})
public class EstadoInmueble implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "estado", nullable = false, length = 255)
    private String estado;
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinTable(name = "estado_estadoinmueble", joinColumns = {
        @JoinColumn(name = "id_estadoInmueble", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "id_inmueble", referencedColumnName = "ID")})
    @ManyToMany
    @JsonIgnore
    private List<Inmuebles> inmueblesList;

    public EstadoInmueble() {
    }

    public EstadoInmueble(Integer id) {
        this.id = id;
    }

    public EstadoInmueble(Integer id, String estado, Date fecha) {
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

    public List<Inmuebles> getInmueblesList() {
        return inmueblesList;
    }

    public void setInmueblesList(List<Inmuebles> inmueblesList) {
        this.inmueblesList = inmueblesList;
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
        if (!(object instanceof EstadoInmueble)) {
            return false;
        }
        EstadoInmueble other = (EstadoInmueble) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.newpackage.EstadoInmueble[ id=" + id + " ]";
    }
    
}
