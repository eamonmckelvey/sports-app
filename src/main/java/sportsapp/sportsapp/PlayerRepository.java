package sportsapp.sportsapp;


import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PlayerRepository extends PagingAndSortingRepository<Player, Long> {

   Player findAllById(Long id);
   //List<Player> findByOrderByPlayerNameAsc();

   @Query("SELECT DISTINCT e.playerName FROM Player e")
   List<String> findAllPlayers(Sort sort);

}
