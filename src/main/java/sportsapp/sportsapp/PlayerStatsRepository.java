package sportsapp.sportsapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatsRepository extends CrudRepository<PlayerStats, Long> {

	PlayerStats findAllById(Long id);

	PlayerStats findAllById(String id);

	List<PlayerStats> findAllByPlayer(final Player player);


}

