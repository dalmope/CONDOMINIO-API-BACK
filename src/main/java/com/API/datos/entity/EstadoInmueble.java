/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.API.datos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
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
