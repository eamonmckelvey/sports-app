package sportsapp.sportsapp;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name="Team_Fixtures")
public class Fixtures implements Serializable {

    @OneToOne
    private User user;
   // private User user;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String matchResult;
    private String score;
    private HomeOrAway homeOrAway;
    public Opponents opponents;
}
