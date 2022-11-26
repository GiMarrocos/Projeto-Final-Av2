package com.tomorrow.tomorrow.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, length = 45)
    private String course_name;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double classWorkload;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double totalWorkload;

    @Column(nullable = false)
    private String shift;

    @Column(nullable = false, precision = 10, scale = 2)
    private Double value;

    @Column(nullable = false)
    private Boolean monday;

    @Column(nullable = false)
    private Boolean tuesday;

    @Column(nullable = false)
    private Boolean wednesday;

    @Column(nullable = false)
    private Boolean thursday;

    @Column(nullable = false)
    private Boolean friday;

    @Column(nullable = false)
    private Boolean saturday;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }
}
