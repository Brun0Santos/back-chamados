package com.santos.helpdesk.enums;

import lombok.Getter;

import java.util.Objects;

@Getter
public enum Profile {
    ADMIN(0L, "ROLE_ADMIN"),
    CLIENT(1L, "ROLE_CLIENT"),
    TECHNIQUE(2L, "ROLE_TECHNIQUE");

    private final Long code;

    private final String description;

    Profile(Long code, String typeRole) {
        this.code = code;
        this.description = typeRole;
    }

    public static Profile toEnum(Long code) {
        if (Objects.isNull(code)) {
            return null;
        }

        for (Profile profiles : Profile.values()) {
            if (code.equals(profiles.getCode())) {
                return profiles;
            }
        }
        throw new RuntimeException("PROFILE NOT FOUND");
    }
}
