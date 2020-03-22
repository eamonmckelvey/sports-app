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

    private int td;
    private int rushYards;
    private int recYards;
    private int rushAttempts;
    private int targets;
    private int returnYards;
    private int throwingYards;
    private int throwAttenpts;
    private int throwSuccess;
    private int receptions;
    private int rushTD;
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

    public Opponents opponents1;
}
