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

    public static DishType fromString(String text) {
        for (var dish : DishType.values()) {
            if (dish.type.equalsIgnoreCase(text)) {
                return dish;
            }
        }
        return DishType.values()[0];
    }
}
