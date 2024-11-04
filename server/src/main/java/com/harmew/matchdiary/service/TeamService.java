package com.harmew.matchdiary.service;

import com.harmew.matchdiary.dto.team.TeamResponseDTO;

public interface TeamService {

    /**
     * GetTeam by Id
     */
    TeamResponseDTO getTeamById(final Integer id);
}
