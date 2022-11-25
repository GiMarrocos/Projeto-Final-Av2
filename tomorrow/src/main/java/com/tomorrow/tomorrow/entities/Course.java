package com.tomorrow.tomorrow.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

//Anotações
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    private Integer monday;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(course_id, course.course_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course_id);
    }
}
