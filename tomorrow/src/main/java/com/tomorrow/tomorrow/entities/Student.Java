package com.tomorrow.tomorrow.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
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

    @Column(nullable = false)
    private Long team;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id_student, student.id_student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_student);
    }
}
