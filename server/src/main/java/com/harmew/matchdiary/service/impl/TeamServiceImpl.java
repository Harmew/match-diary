package com.harmew.matchdiary.service.impl;

import com.harmew.matchdiary.dto.team.TeamRequestDTO;
import com.harmew.matchdiary.dto.team.TeamResponseDTO;
import com.harmew.matchdiary.model.Team;
import com.harmew.matchdiary.repository.TeamRepository;
import com.harmew.matchdiary.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    public final TeamRepository repository;

    public TeamServiceImpl(TeamRepository repository) {
        this.repository = repository;
    }

    public TeamResponseDTO getTeamById(final Integer id) {
        if (id <= 0) return null;

        Optional<Team> team = repository.findById(id);
        return team.map(TeamResponseDTO::new).orElse(null);
    }

    public List<TeamResponseDTO> getAllTeams() {
        return repository.findAll().stream().map(TeamResponseDTO::new).toList();
    }

    public TeamResponseDTO createTeam(final TeamRequestDTO data) {
        if (data.name().isEmpty() || data.state().isEmpty() || data.photoUrl().isEmpty()) return null;

        Team team = repository.save(new Team(data));
        return new TeamResponseDTO(team);
    }

    public TeamResponseDTO updateTeam(final Integer id, final TeamRequestDTO data) {
        Team team = repository.getReferenceById(id);

        if (data.name() != null) {
            team.setName(data.name());
        }

        if (data.state() != null) {
            team.setState(data.state());
        }

        if (data.photoUrl() != null) {
            team.setPhotoUrl(data.photoUrl());
        }

        return new TeamResponseDTO(repository.save(team));
    }

    public void deleteTeam(final Integer id) {
        repository.deleteById(id);
    }

}
