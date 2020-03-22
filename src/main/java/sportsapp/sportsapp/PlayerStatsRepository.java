package sportsapp.sportsapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatsRepository extends CrudRepository<PlayerStats, Long> {

    PlayerStats findAllById(Long id);

    PlayerStats findAllById(String id);


}

