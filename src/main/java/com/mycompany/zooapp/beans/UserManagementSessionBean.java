/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatefulEjbClass.java to edit this template
 */
package com.mycompany.zooapp.beans;

import com.mycompany.zooapp.entities.Role;
import com.mycompany.zooapp.entities.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Emoooo
 */
@Stateless
public class UserManagementSessionBean implements UserManagementSessionBeanLocal {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    public User login(String username, String password) {

        try {

            return em.createQuery("select u from User u where u.userName = :username And u.password = :password", User.class)
                    .setParameter("username", username)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public boolean userExists(String username) {
        try {
            em.createQuery("SELECT u FROM User u WHERE u.userName = :username", User.class)
                    .setParameter("username", username)
                    .getSingleResult();
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }

    @Override
    public Role getDefaultRole() {
        return em.createQuery("SELECT r FROM Role r WHERE r.roleName = 'guest'", Role.class)
                .getSingleResult();
    }

    @Override
    public void registerUser(User user) {
        em.persist(user);
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
