package com.tomorrow.tomorrow.entities.enums;

import lombok.Getter;

@Getter
public enum KindOfHoliday {

    NATIONAL(1),
    REGIONAL(2);

    private int status_code;

    private KindOfHoliday(int status_code){
        this.status_code = status_code;
    }

    public static KindOfHoliday valueOf(int status_code){
        for(KindOfHoliday code: KindOfHoliday.values()){
            if(code.getStatus_code() == status_code){
                return code;
            }
        }
        throw new IllegalArgumentException("Holiday type code is not valid");
    }

}
