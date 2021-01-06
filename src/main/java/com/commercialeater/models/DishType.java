package com.commercialeater.models;

public enum DishType {
    APPETIZERS("Appetizers"),
    MAIN_COURSES("Main Courses"),
    SIDES("Sides"),
    DRINKS("Drinks"),
    OTHERS("Others");

    private final String type;

    DishType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
