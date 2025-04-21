/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zooapp.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Emoooo
 */
@Entity
@Table(name = "cage")
@NamedQueries({
    @NamedQuery(name = "Cage.findAll", query = "SELECT c FROM Cage c"),
    @NamedQuery(name = "Cage.findByCageId", query = "SELECT c FROM Cage c WHERE c.cageId = :cageId"),
    @NamedQuery(name = "Cage.findByCageNO", query = "SELECT c FROM Cage c WHERE c.cageNO = :cageNO"),
    @NamedQuery(name = "Cage.findByLocation", query = "SELECT c FROM Cage c WHERE c.location = :location")})
public class Cage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cage_Id")
    private Integer cageId;
    @Column(name = "Cage_NO")
    private Integer cageNO;
    @Size(max = 45)
    @Column(name = "Location")
    private String location;
    @JoinColumn(name = "Animal_Id", referencedColumnName = "Animal_Id")
    @OneToOne(fetch = FetchType.LAZY)
    private Animal animalId;

    public Cage() {
    }

    public Cage(Integer cageId) {
        this.cageId = cageId;
    }

    public Integer getCageId() {
        return cageId;
    }

    public void setCageId(Integer cageId) {
        this.cageId = cageId;
    }

    public Integer getCageNO() {
        return cageNO;
    }

    public void setCageNO(Integer cageNO) {
        this.cageNO = cageNO;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cageId != null ? cageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cage)) {
            return false;
        }
        Cage other = (Cage) object;
        if ((this.cageId == null && other.cageId != null) || (this.cageId != null && !this.cageId.equals(other.cageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.zooapp.entities.Cage[ cageId=" + cageId + " ]";
    }
    
}
