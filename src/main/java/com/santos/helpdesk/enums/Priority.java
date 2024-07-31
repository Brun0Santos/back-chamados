package com.santos.helpdesk.enums;

import java.util.Objects;

public enum Priority {
    LOW(0L, "LOW"), AVERAGE(1L, "AVERAGE"), HIGH(2L, "HIGH");

    private final Long code;

    private final String description;

    Priority(Long code, String typeRole) {
        this.code = code;
        this.description = typeRole;
    }

    public Long getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Priority toEnum(Long code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (Priority profiles : Priority.values()) {
            if (code.equals(profiles.getCode())) {
                return profiles;
            }
        }
        throw new RuntimeException("STATUS NOT FOUND");
    }
}
