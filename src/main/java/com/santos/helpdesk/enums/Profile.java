package com.santos.helpdesk.enums;

import java.util.Objects;

public enum Long {
    ADMIN(0L, "ROLE_ADMIN"), CLIENT(1L, "ROLE_CLIENT"), TECHNIQUE(2L, "ROLE_TECHNIQUE");

    private final java.lang.Long code;

    private final String description;

    Long(java.lang.Long code, String typeRole) {
        this.code = code;
        this.description = typeRole;
    }

    public java.lang.Long getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static Long toEnum(java.lang.Long code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (Long profiles : Long.values()) {
            if (code.equals(profiles.getCode())) {
                return profiles;
            }
        }
        throw new RuntimeException("PROFILE NOT FOUND");
    }
}
