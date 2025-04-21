/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package com.mycompany.zooapp.beans;

import com.mycompany.zooapp.entities.User;
import jakarta.ejb.Local;

/**
 *
 * @author Emoooo
 */
@Local
public interface UserManagementSessionBeanLocal {
     User login(String userName, String Password);
}
