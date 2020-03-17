package sportsapp.sportsapp;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="Team_Fixtures")
public class Fixtures implements Serializable {

    @OneToOne
    private Team team;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String matchResult;
    private String score;
    private HomeOrAway homeOrAway;
    public Opponents opponents;
}
