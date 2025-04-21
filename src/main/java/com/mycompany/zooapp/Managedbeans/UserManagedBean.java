/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.zooapp.Managedbeans;

import com.mycompany.zooapp.beans.UserManagementSessionBeanLocal;
import com.mycompany.zooapp.entities.User;
import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

/**
 *
 * @author Emoooo
 */
@Named(value = "userManagedBean")
@SessionScoped
public class UserManagedBean implements Serializable {

    private String username;
    private String password;
    private User loggedInUser;

    @EJB
    private UserManagementSessionBeanLocal userBean;

    public String login() {
        User user = userBean.login(username, password);
        if (user != null) {
            loggedInUser = user;
            String role = user.getRoleId().getRoleName();
            if ("admin".equalsIgnoreCase(role)) {
                return "index.xhml?faces-direct=true";
            }else if("guste".equalsIgnoreCase(role)){
                return "guest.xhtml?faces-redirect=true";
            }else if("user".equalsIgnoreCase(role)) {
                return "users.xhtml?faces-redirect=true";
            }
            else {
                return "home.xhtml?faces-redirect=true";
            }
        }
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid credentials", null));

        return null;

    }

    public String logOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login.xhtml?faces-redirect=true";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
