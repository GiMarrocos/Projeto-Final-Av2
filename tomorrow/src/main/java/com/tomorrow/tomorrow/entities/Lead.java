package com.tomorrow.tomorrow.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Lead {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lead;

    @Column(nullable = false, length = 45)
    private String name;

    @Column(nullable = false, length = 20)
    private String phone;


    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT")
    private Date dateRegister;

    @Column(nullable = false, length = 20)
    private String status_2;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date newDateContact;

    @Column(nullable = false, length = 45)
    private String observation;
}
