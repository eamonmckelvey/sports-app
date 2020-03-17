package sportsapp.sportsapp;

public enum HomeOrAway {
    HOME("Home"),
    AWAY("Away");


    private final String displayValue;

    private HomeOrAway(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
