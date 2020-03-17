package sportsapp.sportsapp;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="User_Player")
public class Player implements Serializable {

    @OneToOne
    private User user;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String playerName;
    private String dob;
    private String hometown;
    private String weight;
    private String height;
    private Position position;



}
