/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.API.datos.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author David Alberto Mora Peñaranda
 */
@Entity
@Table(name = "escenarios")
@NamedQueries({
    @NamedQuery(name = "Escenarios.findAll", query = "SELECT e FROM Escenarios e"),
    @NamedQuery(name = "Escenarios.findById", query = "SELECT e FROM Escenarios e WHERE e.id = :id"),
    @NamedQuery(name = "Escenarios.findByNombre", query = "SELECT e FROM Escenarios e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Escenarios.findByDescripcion", query = "SELECT e FROM Escenarios e WHERE e.descripcion = :descripcion")})
public class Escenarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEscenarios")
    private Set<Alquiler> alquilerSet;

    public Escenarios() {
    }

    public Escenarios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<Alquiler> getAlquilerSet() {
        return alquilerSet;
    }

    public void setAlquilerSet(Set<Alquiler> alquilerSet) {
        this.alquilerSet = alquilerSet;
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
        if (!(object instanceof Escenarios)) {
            return false;
        }
        Escenarios other = (Escenarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.newpackage.Escenarios[ id=" + id + " ]";
    }
    
}
