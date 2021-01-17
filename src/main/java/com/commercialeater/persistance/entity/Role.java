package com.commercialeater.persistance.entity;

public enum Role {
    ADMIN("Admin"),
    USER("User");

    private final String type;

    Role(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Role fromString(String text) {
        for (var role : Role.values()) {
            if (role.type.equalsIgnoreCase(text)) {
                return role;
            }
        }
        return Role.values()[0];
    }
}
