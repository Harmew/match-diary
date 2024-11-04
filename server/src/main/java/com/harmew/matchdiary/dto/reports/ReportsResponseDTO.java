package com.harmew.matchdiary.dto.reports;

import com.harmew.matchdiary.dto.team.TeamResponseDTO;

public record ReportsResponseDTO(
        Integer matchesQuantity,
        Integer winsQuantity,
        Double winPercentage,
        TeamResponseDTO team
) {

}
