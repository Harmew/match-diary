package com.harmew.matchdiary.dto.team;

import com.harmew.matchdiary.model.Team;

public record TeamResponseDTO(
        Integer id,
        String name,
        String state,
        String photoUrl
) {
    public TeamResponseDTO(Team team) {
        this(
                team.getId(),
                team.getName(),
                team.getState(),
                team.getPhotoUrl()
        );
    }
}
