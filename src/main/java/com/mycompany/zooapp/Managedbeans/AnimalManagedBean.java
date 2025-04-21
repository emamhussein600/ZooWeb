/*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.zooapp.Managedbeans;

import com.mycompany.zooapp.beans.AnimalManagementBeanLocal;
import com.mycompany.zooapp.entities.Animal;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Emoooo
 */
@Named(value = "animalManagedBean")
@ViewScoped
public class AnimalManagedBean implements Serializable {

    @EJB
    private AnimalManagementBeanLocal animalManagementBeanLocal;

    private List<Animal> animalList;

    private Animal animal;

    private int categoryId;

    private int cageId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCageId() {
        return cageId;
    }

    public void setCageId(int cageId) {
        this.cageId = cageId;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @PostConstruct
    public void intit() {
        animalList = animalManagementBeanLocal.getAllAnimals();
        animal = new Animal();
    }

    public void loadById() {
        animal = animalManagementBeanLocal.findById(animal.getAnimalId());
    }

    public String loadAnimal(Animal selectAnimal) {

        return "updateAnimal.xhtml?faces-redirect=true&animalId= " + selectAnimal.getAnimalId();
    }

    public String addpage() {
        return "addAnimal.xhtml?faces-redirect=true";
    }

    public String updateAnimal() {
        animalManagementBeanLocal.updateAnimal(animal, animal.getAnimalId());
        System.out.println("Id is " + animal.getAnimalId());
        return "index.xhtml?faces-redirect=true";
    }

    public void deleteAnimal(Animal selected) {
        if (selected == null) {
            return;
        }
        animalManagementBeanLocal.deleteAnimal(selected.getAnimalId());
        animalList = animalManagementBeanLocal.getAllAnimals();
    }

    public void addTestAnimal() {
        animalManagementBeanLocal.addAnimal(animal, categoryId, cageId); 
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}
