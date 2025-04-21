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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emoooo
 */
@Entity
@Table(name = "food_item")
@NamedQueries({
    @NamedQuery(name = "FoodItem.findAll", query = "SELECT f FROM FoodItem f"),
    @NamedQuery(name = "FoodItem.findByFoodItemId", query = "SELECT f FROM FoodItem f WHERE f.foodItemId = :foodItemId"),
    @NamedQuery(name = "FoodItem.findByName", query = "SELECT f FROM FoodItem f WHERE f.name = :name"),
    @NamedQuery(name = "FoodItem.findByQuantity", query = "SELECT f FROM FoodItem f WHERE f.quantity = :quantity")})
public class FoodItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Food_Item_Id")
    private Integer foodItemId;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Column(name = "Quantity")
    private Integer quantity;
    @ManyToMany(mappedBy = "foodItemList", fetch = FetchType.LAZY)
    private List<Animal> animalList;

    public FoodItem() {
    }

    public FoodItem(Integer foodItemId) {
        this.foodItemId = foodItemId;
    }

    public Integer getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Integer foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
        hash += (foodItemId != null ? foodItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodItem)) {
            return false;
        }
        FoodItem other = (FoodItem) object;
        if ((this.foodItemId == null && other.foodItemId != null) || (this.foodItemId != null && !this.foodItemId.equals(other.foodItemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.zooapp.entities.FoodItem[ foodItemId=" + foodItemId + " ]";
    }
    
}
