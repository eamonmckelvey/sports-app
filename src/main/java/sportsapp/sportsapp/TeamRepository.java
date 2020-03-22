package sportsapp.sportsapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findAllById(Long id);


    long countAllByUser(final User user);

}
