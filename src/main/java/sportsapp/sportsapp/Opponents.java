package sportsapp.sportsapp;

public enum Opponents {
    ARIZONA_CARDINALS("Cardinals"),
    ATLANTA_FALCONS("Falcons"),
    BALTIMORE_RAVENS("Ravens"),
    BUFFALO_BILLS("Bills"),
    CAROLINA_PANTHERS("Panthers"),
    CINCINNATI_BENGALS("Bengals"),
    CHICAGO_BEARS("Bears"),
    CLEVELAND_BROWNS("Browns"),
    DALLAS_COWBOYS("Cowboys"),
    DENVER_BRONCOS("Broncos"),
    DETROIT_LIONS("Lions"),
    GREENBAY_PACKERS("Packers"),
    HOUSTON_TEXANS("Texans"),
    INDIANAPOLIS_COLTS("Colts"),
    JACKSONVILLE_JAGUARS("Jaguars"),
    KANSASCITY_CHIEFS("Chiefs"),
    LA_CHARGERS("Chargers"),
    LA_RAMS("Rams"),
    MIAMI_DOLPHINS("Dolphins"),
    MINNESOTA_VIKINGS("Vikings"),
    NE_PATRIOTS("Patriots"),
    NO_SAINTS("Saints"),
    NY_JETS("Jets"),
    NY_GIANTS("Giants"),
    OAKLAND_RAIDERS("Raiders"),
    PHILADELPHIA_EAGLES("Eagles"),
    SANFRAN_49ERS("49ers"),
    SEAHAWKS("Seahawks"),
    TAMPABAY_BUCCANEERS("Tampa Bay"),
    TENNESSEE_TITANS("Titans"),
    WASHINGTON_REDSKINS("Redskins");


    private final String displayValue;

    private Opponents(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}