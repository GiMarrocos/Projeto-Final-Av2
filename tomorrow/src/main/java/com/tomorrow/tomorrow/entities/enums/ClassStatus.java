package com.tomorrow.tomorrow.entities.enums;

import lombok.Getter;

@Getter
public enum ClassStatus {

    SCHEDULED(0),
    CANCELED(1),
    REMARKED(2),
    UNSCHEDULED(3);

    private int status_code;

    private ClassStatus(int status_code){
        this.status_code = status_code;
    }

    public static ClassStatus valueOf(int status_code){
        for(ClassStatus code:ClassStatus.values()){
            if(code.getStatus_code() == status_code){
                return code;
            }
        }
        throw new IllegalArgumentException("class status type code is not valid");
    }
}
