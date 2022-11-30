package com.tomorrow.tomorrow.entities;

import lombok.*;
import org.springframework.data.annotation.Reference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Table
@Entity
public class Student implements Serializable {
    private static final long serializable = 1L;

    @EqualsAndHashCode.Include
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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "class_id", referencedColumnName = "id")
    private Class team;


}
