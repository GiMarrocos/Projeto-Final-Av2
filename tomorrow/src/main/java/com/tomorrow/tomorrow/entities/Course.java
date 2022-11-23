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
public class Course {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long course_id;

    @Column(nullable = false, length = 45)
    private String courseName;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double classWorkload;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double totalWorkload;

    @Column(nullable = false, length = 20)
    private String shift;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double value;

    @Column(nullable = false)
    private Byte monday;

    @Column(nullable = false)
    private Byte tuesday;

    @Column(nullable = false)
    private Byte wednesday;

    @Column(nullable = false)
    private Byte thursday;

    @Column(nullable = false)
    private Byte friday;

    @Column(nullable = false)
    private Byte saturday;
}
