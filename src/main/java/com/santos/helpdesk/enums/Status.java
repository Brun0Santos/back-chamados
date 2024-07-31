package com.santos.helpdesk.enums;

import java.util.Objects;

public enum Status {
    OPEN(0L, "OPEN"), PROGRESS(1L, "PROGRESS"), CLOSED(2L, "CLOSED");

    private final Long code;

    private final String description;

    Status(Long code, String typeRole) {
        this.code = code;
        this.description = typeRole;
    }

    public Long getCode() {
        return code;
    }

    public String getDescription() {
        return description;
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
