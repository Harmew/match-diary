package com.harmew.matchdiary.service.impl;

import com.harmew.matchdiary.dto.team.TeamResponseDTO;
import com.harmew.matchdiary.model.Team;
import com.harmew.matchdiary.repository.TeamRepository;
import com.harmew.matchdiary.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    public final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamResponseDTO getTeamById(final Integer id) {
        Optional<Team> team = repository.findById(id);
        return team.map(TeamResponseDTO::new).orElse(null);
    }
}
