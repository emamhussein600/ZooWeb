/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zooapp.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author Emoooo
 */
@Entity
@Table(name = "staffs")
@NamedQueries({
    @NamedQuery(name = "Staffs.findAll", query = "SELECT s FROM Staffs s"),
    @NamedQuery(name = "Staffs.findByStaffId", query = "SELECT s FROM Staffs s WHERE s.staffId = :staffId"),
    @NamedQuery(name = "Staffs.findByName", query = "SELECT s FROM Staffs s WHERE s.name = :name"),
    @NamedQuery(name = "Staffs.findByAge", query = "SELECT s FROM Staffs s WHERE s.age = :age"),
    @NamedQuery(name = "Staffs.findBySalary", query = "SELECT s FROM Staffs s WHERE s.salary = :salary"),
    @NamedQuery(name = "Staffs.findByGender", query = "SELECT s FROM Staffs s WHERE s.gender = :gender")})
public class Staffs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Staff_Id")
    private Integer staffId;
    @Size(max = 45)
    @Column(name = "Name")
    private String name;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Salary")
    private Integer salary;
    @Size(max = 45)
    @Column(name = "Gender")
    private String gender;
    @Lob
    @Column(name = "Pic")
    private byte[] pic;

    public Staffs() {
    }

    public Staffs(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staffs)) {
            return false;
        }
        Staffs other = (Staffs) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.zooapp.entities.Staffs[ staffId=" + staffId + " ]";
    }
    
}
