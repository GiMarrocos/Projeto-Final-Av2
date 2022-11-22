package com.tomorrow.tomorrow.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Teacher {
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id; 

    @Column (nullable = false, length = 45)
    private String name; 

	@Column (nullable = false, length = 20)
    private String phone; 

	@Column (nullable = false)
    private Double money_hour_class ; 

	public Teacher() {

	} 

	public Teacher(Long teacher_id, String name, String phone, Double money_hour_class) {

		this.teacher_id = teacher_id; 
		this.name = name; 
		this.phone = phone;
		this.money_hour_class = money_hour_class; 
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

	public Double getMoney_hour_class(Double money_hour_class){

        return money_hour_class; 
    }

	public void setMoney_hour_class (Double money_hour_class) {

		this.money_hour_class = money_hour_class; 
	}

	public Long getTeacher_id() {

        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
		
        this.teacher_id = teacher_id;
    }


}
