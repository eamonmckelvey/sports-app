package sportsapp.sportsapp;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity
@Table(name="Player_Stats")


public class PlayerStats implements Serializable {

    @ManyToOne
    private Player player;


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private double rushYards;

    private int rushAttempts;
    private double yardsPerAttempt;
    private int rushTD;

    private int returnYards;

    private int td;
    private double throwingYards;
    private double throwAttenpts;
    private double throwSuccess;
    private double throwSuccessPercent;
    private int ints;
    private double qbRating;



    private double targets;
    private double receptions;
    private double recYards;
    private double yardsPerCatch;
    public  double catchSuccess;
    private int recTD;
    private int fumbles;
    private int fumblesRecovered;

    private int forcedFumbles;
    private int sacks;
    private int puntsBlocked;
    private int fgScored;
    private int fgMissed;
    private int punts;
    private int tackle;

    private double passerRating;

    public Opponents opponents1;

    public void CatchSuccess() {



        catchSuccess = 100 * (receptions/targets);
    }

    public void ThrowSuccessPercent() {

        throwSuccessPercent = 100 * (throwSuccess / throwAttenpts);
    }

    public void YardsPerAttempt() {

        yardsPerAttempt = Math.round(rushYards / rushAttempts);
    }

    public void YardsPerCatch() {

        yardsPerCatch = Math.round( recYards / receptions);
    }

    public void QbRating() {

        qbRating = (throwAttenpts / throwSuccess) * 100;
    }

    public void calculateNflPasserRating() {

        double a = (throwSuccess  / throwAttenpts - 0.3) * 5.0;
        double b = (throwingYards / throwAttenpts - 3.0) * 0.25;
        double c = ((double)td          / throwAttenpts) * 20.0;
        double d = 2.375 - ((double)ints / throwAttenpts * 25.0);
        passerRating = ( (a+b+c+d) / 6.0 ) * 100.0;

    }



}
