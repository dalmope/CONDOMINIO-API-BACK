/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.API.datos.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 *
 * @author David Alberto Mora Peñaranda
 */
@Entity
@Table(name = "cuenta")
@NamedQueries({
    @NamedQuery(name = "Cuenta.findAll", query = "SELECT c FROM Cuenta c"),
    @NamedQuery(name = "Cuenta.findById", query = "SELECT c FROM Cuenta c WHERE c.id = :id"),
    @NamedQuery(name = "Cuenta.findByDeudaMensual", query = "SELECT c FROM Cuenta c WHERE c.deudaMensual = :deudaMensual"),
    @NamedQuery(name = "Cuenta.findByMesesMora", query = "SELECT c FROM Cuenta c WHERE c.mesesMora = :mesesMora"),
    @NamedQuery(name = "Cuenta.findByTotal", query = "SELECT c FROM Cuenta c WHERE c.total = :total"),
    @NamedQuery(name = "Cuenta.findByFechaEmision", query = "SELECT c FROM Cuenta c WHERE c.fechaEmision = :fechaEmision"),
    @NamedQuery(name = "Cuenta.findByFechaLimite", query = "SELECT c FROM Cuenta c WHERE c.fechaLimite = :fechaLimite"),
    @NamedQuery(name = "Cuenta.findByRecargo", query = "SELECT c FROM Cuenta c WHERE c.recargo = :recargo")})
public class Cuenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;
    @Column(name = "deuda_mensual", nullable = false)
    private float deudaMensual;
    @Column(name = "meses_mora", nullable = false)
    private int mesesMora;
    @Column(name = "total", nullable = false)
    private float total;
    @Column(name = "fecha_emision", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;
    @Column(name = "fecha_limite", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaLimite;
    @Basic(optional = false)
    @Column(name = "recargo", nullable = false)
    private float recargo;
    @JoinColumn(name = "estado_id", referencedColumnName = "ID")
    @ManyToOne
    private EstadoCuenta estadoId;
    @JoinColumn(name = "id_inmueble", referencedColumnName = "ID")
    @ManyToOne
    private Inmuebles idInmueble;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCuenta")
    private List<Pagos> pagosList;

    public Cuenta() {
    }

    public Cuenta(Integer id) {
        this.id = id;
    }

    public Cuenta(Integer id, float deudaMensual, int mesesMora, float total, Date fechaEmision, Date fechaLimite, float recargo) {
        this.id = id;
        this.deudaMensual = deudaMensual;
        this.mesesMora = mesesMora;
        this.total = total;
        this.fechaEmision = fechaEmision;
        this.fechaLimite = fechaLimite;
        this.recargo = recargo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getDeudaMensual() {
        return deudaMensual;
    }

    public void setDeudaMensual(float deudaMensual) {
        this.deudaMensual = deudaMensual;
    }

    public int getMesesMora() {
        return mesesMora;
    }

    public void setMesesMora(int mesesMora) {
        this.mesesMora = mesesMora;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public float getRecargo() {
        return recargo;
    }

    public void setRecargo(float recargo) {
        this.recargo = recargo;
    }

    @JsonBackReference(value = "estado_cuenta")
    public EstadoCuenta getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(EstadoCuenta estadoId) {
        this.estadoId = estadoId;
    }

    @JsonBackReference(value = "inmueble_cuenta")
    public Inmuebles getIdInmueble() {
        return idInmueble;
    }

    public void setIdInmueble(Inmuebles idInmueble) {
        this.idInmueble = idInmueble;
    }

    @JsonManagedReference(value = "pagos_cuenta")
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Cuenta)) {
            return false;
        }
        Cuenta other = (Cuenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject2.resources.newpackage.Cuenta[ id=" + id + " ]";
    }
    
}

