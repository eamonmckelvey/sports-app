package sportsapp.sportsapp;

public enum Sport {
    Soccer("Soccer"),
    Basketball("Basketball"),
    Football("Football"),
    GaelicFootballI("GAA"),
    Cricket("Cricket"),
    Baseball("Baseball");

    private final String displayName;

    private Sport(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
