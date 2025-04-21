/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package com.mycompany.zooapp.beans;

import com.mycompany.zooapp.entities.Animal;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author Emoooo
 */
@Local
public interface AnimalManagementBeanLocal {
    void addAnimal(Animal animal, int categoryId, int cageId);
    List<Animal> getAllAnimals();
    void updateAnimal(Animal animal, int id);
    Animal findById(int id);
    void deleteAnimal(int animalId); 
    
}
