package com.tomorrow.tomorrow.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table
public class Teacher {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =  45)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double hourlyRate;

    @OneToMany(mappedBy = "teacher")
    private List<Class> classes = new ArrayList<>();


}
