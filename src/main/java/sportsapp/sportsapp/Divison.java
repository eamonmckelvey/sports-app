package sportsapp.sportsapp;

public enum Divison {
    AFC_EAST("AFC East"),
    AFC_WEST("AFC West"),
    AFC_NORTH("AFC North"),
    AFC_SOUTH("AFC South"),
    NFC_EAST("NFC East"),
    NFC_WEST("NFC West"),
    NFC_NORTH("NFC North"),
    NFC_SOUTH("NFC South");

    private final String displayValue;

    private Divison(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
