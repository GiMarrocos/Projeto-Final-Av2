package com.tomorrow.tomorrow.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table
public class Teacher {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length =  45)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double hourlyRate;

    //OneToMany Membership
    @OneToMany(mappedBy = "teacher_id", fetch = FetchType.LAZY)
    private List<Class> classes = new ArrayList<>();


}
