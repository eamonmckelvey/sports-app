package sportsapp.sportsapp;

public enum Position {
    QB("QuarterBack"),
    WR("Wide Receiver"),
    TE("Tight End"),
    RB("Running Back"),
    K("Kicker"),
    KR("Kick Returner"),
    P("Punter"),
    CB("Cornerback"),
    S("Safety"),
    LB("Linebacker"),
    DE("Defensive End"),
    OL("Offensive Lineman"),
    G("Guard");

    private final String displayPosition;

    private Position(String displayPosition) {
        this.displayPosition = displayPosition;
    }

    public String getDisplayPosition() {
        return displayPosition;
    }

}
