package com.tomorrow.tomorrow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Student implements Serializable {
    private static final long serializable = 1L;


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id_student;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 45)
    private String address;

    @Column(nullable = false, length = 20)
    private String cpf;




}
