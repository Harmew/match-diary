package com.harmew.matchdiary.service.impl;

import com.harmew.matchdiary.dto.match.MatchRequestDTO;
import com.harmew.matchdiary.dto.match.MatchResponseDTO;
import com.harmew.matchdiary.model.Match;
import com.harmew.matchdiary.model.Team;
import com.harmew.matchdiary.repository.MatchRepository;
import com.harmew.matchdiary.repository.TeamRepository;
import com.harmew.matchdiary.service.MatchService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final TeamRepository teamRepository;

    public MatchServiceImpl(MatchRepository matchRepository, TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.teamRepository = teamRepository;
    }

    public MatchResponseDTO getMatchById(final Integer id) {
        if (id <= 0) return null;

        Optional<Match> match = matchRepository.findById(id);
        return match.map(MatchResponseDTO::new).orElse(null);
    }

    public List<MatchResponseDTO> getAllMatches() {
        return matchRepository.findAll().stream().map(MatchResponseDTO::new).toList();
    }

    public MatchResponseDTO createMatch(final MatchRequestDTO data) {

        if (data.scoreTeamOne().toString().isEmpty() || data.scoreTeamTwo().toString().isEmpty() || data.supportedTeamId().toString().isEmpty() || data.teamOneId().toString().isEmpty() || data.teamTwoId().toString().isEmpty()) {
            return null;
        }

        if (data.teamOneId().equals(data.teamTwoId())) {
            return null;
        }

        Team teamOne = teamRepository.findById(data.teamOneId()).orElseThrow(() -> new RuntimeException("Error teamOne not find"));
        Team teamTwo = teamRepository.findById(data.teamTwoId()).orElseThrow(() -> new RuntimeException("Error teamTwo not find"));
        Team supportedTeam = teamRepository.findById(data.supportedTeamId()).orElseThrow(() -> new RuntimeException("Error supportedTeam not find"));

        Match match = matchRepository.save(new Match(data, teamOne, teamTwo, supportedTeam));
        return new MatchResponseDTO(match);
    }

    public MatchResponseDTO updateMatch(final Integer id, final MatchRequestDTO data) {
        Match match = matchRepository.getReferenceById(id);

        if (data.scoreTeamOne() != null) {
            match.setScoreTeamOne(data.scoreTeamOne());
        }

        if (data.scoreTeamTwo() != null) {
            match.setScoreTeamTwo(data.scoreTeamTwo());
        }

        if (data.teamOneId() != null) {
            Team teamOne = teamRepository.findById(data.teamOneId()).orElseThrow(() -> new RuntimeException("Error teamOne not find"));
            match.setTeamOne(teamOne);
        }

        if (data.teamTwoId() != null) {
            Team teamTwo = teamRepository.findById(data.teamTwoId()).orElseThrow(() -> new RuntimeException("Error teamTwo not find"));
            match.setTeamTwo(teamTwo);
        }

        if (data.supportedTeamId() != null) {
            Team supportedTeam = teamRepository.findById(data.supportedTeamId()).orElseThrow(() -> new RuntimeException("Error supportedTeam not find"));
            match.setSupportedTeam(supportedTeam);
        }

        return new MatchResponseDTO(matchRepository.save(match));
    }

    public void deleteMatch(final Integer id) {
        matchRepository.deleteById(id);
    }
}
