package com.tomorrow.tomorrow.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "Student", indexes = {
        @Index(name = "idx_student_class_id",
                columnList = "class_id")})
@Entity
public class Student implements Serializable {
    private static final long serializable = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy =  GenerationType.SEQUENCE)
    private Long id_student;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false, length = 45)
    private String address;

    @Column(nullable = false, length = 20)
    private String cpf;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id")
    private Class class_id;

}
