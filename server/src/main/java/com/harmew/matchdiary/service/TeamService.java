package com.harmew.matchdiary.service;

import com.harmew.matchdiary.dto.team.TeamRequestDTO;
import com.harmew.matchdiary.dto.team.TeamResponseDTO;

import java.util.List;

public interface TeamService {

    /**
     * Get Team by ID
     */
    TeamResponseDTO getTeamById(final Integer id);

    /**
     * Get All Teams
     */
    List<TeamResponseDTO> getAllTeams();

    /**
     * Create a new Team
     */
    TeamResponseDTO createTeam(final TeamRequestDTO data);

    /**
     * Update a Team
     */
    TeamResponseDTO updateTeam(final Integer id, final TeamRequestDTO data);

    /**
     * Delete a Team by ID
     */
    void deleteTeam(final Integer id);

}
