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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emoooo
 */
@Entity
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoeyId", query = "SELECT c FROM Category c WHERE c.categoeyId = :categoeyId"),
    @NamedQuery(name = "Category.findByCategoryType", query = "SELECT c FROM Category c WHERE c.categoryType = :categoryType")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Categoey_Id")
    private Integer categoeyId;
    @Size(max = 45)
    @Column(name = "Category_Type")
    private String categoryType;
    @OneToMany(mappedBy = "categoryId", fetch = FetchType.LAZY)
    private List<Animal> animalList;

    public Category() {
    }

    public Category(Integer categoeyId) {
        this.categoeyId = categoeyId;
    }

    public Integer getCategoeyId() {
        return categoeyId;
    }

    public void setCategoeyId(Integer categoeyId) {
        this.categoeyId = categoeyId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoeyId != null ? categoeyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoeyId == null && other.categoeyId != null) || (this.categoeyId != null && !this.categoeyId.equals(other.categoeyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.zooapp.entities.Category[ categoeyId=" + categoeyId + " ]";
    }
    
}
