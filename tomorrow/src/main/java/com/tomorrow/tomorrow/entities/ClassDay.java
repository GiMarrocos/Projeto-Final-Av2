package com.tomorrow.tomorrow.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table
public class ClassDay {

    @Column(nullable = false)
    private Long course_id;

    @Column(nullable = false)
    private Integer classDate;

}
