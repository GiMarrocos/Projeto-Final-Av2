package com.tomorrow.tomorrow.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_Id;

    @Column(nullable = false)
    private Long course_id;

    @Column(nullable = false)
    private Long teacher_id;

    @Column(nullable = false)
    private Double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return Objects.equals(team_Id, aClass.team_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(team_Id);
    }
}
