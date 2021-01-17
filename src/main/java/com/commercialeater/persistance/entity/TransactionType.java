package com.commercialeater.persistance.entity;

public enum TransactionType {
    TOP_UP("Top up"),
    ORDER("Order");

    private final String type;

    TransactionType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static TransactionType fromString(String text) {
        for (var trans : TransactionType.values()) {
            if (trans.type.equalsIgnoreCase(text)) {
                return trans;
            }
        }
        return TransactionType.values()[0];
    }
}
