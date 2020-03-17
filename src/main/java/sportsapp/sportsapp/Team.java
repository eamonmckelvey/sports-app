package sportsapp.sportsapp;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="User_Team")
public class Team implements Serializable {


    @OneToOne
    private User user;

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotBlank(message="Team Name is required")
    private  String teamName;

    @NotBlank(message="Location is required")
    private  String location;

    @NotBlank(message="Nickname required")
    private String nickName;

    private String yearEstablished;


    public Sport sport;

    private Divison divison;


}
