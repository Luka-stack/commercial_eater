package com.commercialeater.models;

public enum Diet {
    NONE("None"),
    VEGAN("Vegan"),
    VEGETARIAN("Vegetarian");

    private final String type;

    Diet(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static Diet fromString(String text) {
        for (var diet : Diet.values()) {
            if (diet.type.equalsIgnoreCase(text)) {
                return diet;
            }
        }
        return Diet.values()[0];
    }
}
