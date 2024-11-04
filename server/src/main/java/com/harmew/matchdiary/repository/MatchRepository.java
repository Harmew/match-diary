package com.harmew.matchdiary.repository;

import com.harmew.matchdiary.model.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Integer> {

    @Query("SELECT m FROM match m WHERE m.supportedTeam.id = :id")
    List<Match> findAllBySupportedTeamId(@Param("id") Integer id);

}
