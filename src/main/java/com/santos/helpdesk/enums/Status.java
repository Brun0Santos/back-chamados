package com.santos.helpdesk.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum Status {
    OPEN(0L, "OPEN"),
    PROGRESS(1L, "PROGRESS"),
    CLOSED(2L, "CLOSED");

    private final Long code;

    private final String description;

    Status(Long code, String typeRole) {
        this.code = code;
        this.description = typeRole;
    }

    public static Status toEnum(Long code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (Status profiles : Status.values()) {
            if (code.equals(profiles.getCode())) {
                return profiles;
            }
        }
        throw new RuntimeException("STATUS NOT FOUND");
    }
}
