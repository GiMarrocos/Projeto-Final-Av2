package com.tomorrow.tomorrow.entities;


import com.tomorrow.tomorrow.entities.enums.ClassStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@Table
@Entity
public class Course {

    @EqualsAndHashCode.Include
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
    private Integer monday;

    @Column(nullable = false)
    private Integer tuesday;

    @Column(nullable = false)
    private Integer wednesday;

    @Column(nullable = false)
    private Integer thursday;

    @Column(nullable = false)
    private Integer friday;

    @Column(nullable = false)
    private Integer saturday;

    //many-to-many


    public Course(Long courseId, String course_name, Double classWorkload, Double totalWorkload, String shift,
                  Double value, ClassStatus monday, ClassStatus tuesday, ClassStatus wednesday,
                  ClassStatus thursday, ClassStatus friday, ClassStatus saturday) {
        this.courseId = courseId;
        this.course_name = course_name;
        this.classWorkload = classWorkload;
        this.totalWorkload = totalWorkload;
        this.shift = shift;
        this.value = value;
        setMonday(monday);
        setThursday(tuesday);
        setWednesday(wednesday);
        setThursday(thursday);
        setFriday(friday);
        setSaturday(saturday);
    }


    public ClassStatus getMonday() {
        return ClassStatus.valueOf(monday);
    }

    public void setMonday(ClassStatus monday) {
        this.monday = monday.getStatus_code();
    }

    public ClassStatus getTuesday() {
        return ClassStatus.valueOf(tuesday);
    }

    public void setTuesday(ClassStatus tuesday) {
        this.tuesday = tuesday.getStatus_code();
    }

    public ClassStatus getWednesday() {
        return ClassStatus.valueOf(wednesday);
    }

    public void setWednesday(ClassStatus wednesday) {
        this.wednesday = wednesday.getStatus_code();
    }

    public ClassStatus getThursday() {
        return ClassStatus.valueOf(thursday);
    }

    public void setThursday(ClassStatus thursday) {
        this.thursday = thursday.getStatus_code();
    }

    public ClassStatus getFriday() {
        return ClassStatus.valueOf(friday);
    }

    public void setFriday(ClassStatus friday) {
        this.friday = friday.getStatus_code();
    }

    public ClassStatus getSaturday() {
        return ClassStatus.valueOf(saturday);
    }

    public void setSaturday(ClassStatus saturday) {
        this.saturday = saturday.getStatus_code();
    }

}
