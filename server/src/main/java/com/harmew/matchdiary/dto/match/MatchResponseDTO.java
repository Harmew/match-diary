package com.harmew.matchdiary.dto.match;

import com.harmew.matchdiary.model.Match;
import com.harmew.matchdiary.model.Team;

import java.time.Instant;

public record MatchResponseDTO(
        Integer id,
        Instant date,
        Integer scoreTeamOne,
        Integer scoreTeamTwo,
        Team teamOne,
        Team teamTwo,
        Team supportedTeam
) {
    public MatchResponseDTO(Match match) {
        this(
                match.getId(),
                match.getDate(),
                match.getScoreTeamOne(),
                match.getScoreTeamTwo(),
                match.getTeamOne(),
                match.getTeamTwo(),
                match.getSupportedTeam()
        );
    }
}
