package com.harmew.matchdiary.service;

import com.harmew.matchdiary.dto.match.MatchRequestDTO;
import com.harmew.matchdiary.dto.match.MatchResponseDTO;

import java.util.List;

public interface MatchService {

    /**
     * Get Match by ID
     */
    MatchResponseDTO getMatchById(final Integer id);

    /**
     * Get All Matches
     */
    List<MatchResponseDTO> getAllMatches();

    /**
     * Create a new Match
     */
    MatchResponseDTO createMatch(final MatchRequestDTO data);

    /**
     * Update a Match
     */
    MatchResponseDTO updateMatch(final Integer id, final MatchRequestDTO data);

    /**
     * Delete a Match by ID
     */
    void deleteMatch(final Integer id);
}
