package sportsapp.sportsapp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FixturesRepository extends CrudRepository<Fixtures, Long> {

    Fixtures findAllById(Long id);

}

