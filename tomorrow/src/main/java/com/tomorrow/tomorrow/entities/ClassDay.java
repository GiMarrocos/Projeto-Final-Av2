package com.tomorrow.tomorrow.entities;

import com.tomorrow.tomorrow.entities.enums.ClassStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Table
public class ClassDay {

    @OneToOne
    @JoinColumn(name = "course_id_course")
    private Course course_id_course;

    @Column(nullable = false)
    private Integer classDate;

    public ClassDay(Course course_id, ClassStatus classDate) {
        this.course_id_course = course_id;
        setClassDate(classDate);
    }

    public ClassStatus getClassDate() {
        return ClassStatus.valueOf(classDate);
    }

    public void setClassDate(ClassStatus classDate) {
        this.classDate = classDate.getStatus_code();
    }
}
