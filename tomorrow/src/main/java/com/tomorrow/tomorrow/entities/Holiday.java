package com.tomorrow.tomorrow.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tomorrow.tomorrow.entities.enums.KindOfHoliday;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String holiday_id;

    @Column(nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT")
    private Date holidayDate;

    @Column(nullable = false)
    private Integer description;


    public Holiday(String holiday_id, Date holidayDate, KindOfHoliday description) {
        this.holiday_id = holiday_id;
        this.holidayDate = holidayDate;
        setDescription(description);
    }

    public KindOfHoliday getDescription() {
        return KindOfHoliday.valueOf(description);
    }

    public void setDescription(KindOfHoliday description) {
        if(description != null) {
            this.description = description.getStatus_code();
        }
    }
}