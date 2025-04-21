/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package com.mycompany.zooapp.beans;

import com.mycompany.zooapp.entities.Animal;
import com.mycompany.zooapp.entities.Cage;
import com.mycompany.zooapp.entities.Category;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author Emoooo
 */
@Stateless
public class AnimalManagementBean implements AnimalManagementBeanLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    public void addAnimal(Animal animal, int categoryId, int cageId) {
        Category category = em.find(Category.class, categoryId);
        Cage existCage = em.find(Cage.class, cageId);
        if (category == null || existCage == null) {
            return;
        }

        animal.setCategoryId(category);
        animal.setCage(existCage);
        em.persist(animal);
        category.getAnimalList().add(animal);
        existCage.setAnimalId(animal);

    }

    @Override
    public List<Animal> getAllAnimals() {

        return em.createNamedQuery("Animal.findAll", Animal.class).getResultList();
    }

    @Override
    public void updateAnimal(Animal animal, int animalId) {

        Animal updatedAnimal = em.find(Animal.class, animalId);
        if (updatedAnimal != null) {
            updatedAnimal.setTotalNo(animal.getTotalNo());
            updatedAnimal.setType(animal.getType());
            em.merge(updatedAnimal);
        }

    }

    @Override
    public Animal findById(int id) {
        return em.find(Animal.class, id);
    }

    @Override
    public void deleteAnimal(int animalId) {
        Animal animal = em.find(Animal.class, animalId);
        if (animal != null && animal.getCage() != null) {
            animal.getCage().setAnimalId(null); // if bidirectional
            animal.setCage(null);
        }
        if(animal != null){
            em.remove(em.contains(animal) ? animal : em.merge(animal));
        }
        
    }

}
