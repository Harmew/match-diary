package com.harmew.matchdiary.dto.match;

import java.time.Instant;

public record MatchRequestDTO(
        Instant date,
        Integer scoreTeamOne,
        Integer scoreTeamTwo,
        Integer teamOneId,
        Integer teamTwoId,
        Integer supportedTeamId
) {

}
