package com.tomorrow.tomorrow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacher_id;

    @Column(nullable = false, length =  45)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double hourlyRate;




}
