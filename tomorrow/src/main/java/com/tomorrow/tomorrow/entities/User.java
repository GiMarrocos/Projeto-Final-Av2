package com.tomorrow.tomorrow.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT")
    private Date registrationDate;

    @Column(nullable = false, length = 15, unique = true)
    private String login;

    @Column(nullable = false, length = 12)
    private String password;

    @Column(nullable = false, length = 1)
    private Character profile; //S - Student or T - Teacher

    @Column(nullable = false, length = 1)
    private Character status; //A - Active or I - Inactive
}
