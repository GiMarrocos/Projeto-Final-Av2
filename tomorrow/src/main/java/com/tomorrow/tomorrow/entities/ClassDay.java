package com.tomorrow.tomorrow.entities;

import com.tomorrow.tomorrow.entities.enums.ClassStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@EqualsAndHashCode
@Table
public class ClassDay {

    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private Long course_id;

    @Column(nullable = false)
    private Integer classDate;

    public ClassDay(Long course_id, ClassStatus classDate) {
        this.course_id = course_id;
        setClassDate(classDate);
    }

    public ClassStatus getClassDate() {
        return ClassStatus.valueOf(classDate);
    }

    public void setClassDate(ClassStatus classDate) {
        this.classDate = classDate.getStatus_code();
    }
}
