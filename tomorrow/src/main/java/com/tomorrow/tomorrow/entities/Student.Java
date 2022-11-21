package com.tomorrow.tomorrow.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student {
    

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id; 

    @Column (nullable = false, length = 45)
    private String name; 

    @Column (nullable = false, length = 20)
    private String phone; 

    @Column (nullable = false, length = 45)
    private String address; 

   @Column (nullable = false, length = 20)
    private String cpf; 

    public Student () {

    }

    public Student(Long student_id, String name, String phone, String address, String cpf) {
        this.student_id = student_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.cpf = cpf;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone(){
        return phone; 
    }

    public void setPhone (String phone){
        this.phone = phone;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress (String address){
        this.address = address; 
    }

    public String getCpf (){
        return cpf;
    }
    
    public void setCpf (String cpf){
        this.cpf = cpf;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

}

