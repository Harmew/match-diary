package com.harmew.matchdiary.service.impl;

import com.harmew.matchdiary.dto.reports.ReportsResponseDTO;
import com.harmew.matchdiary.model.Match;
import com.harmew.matchdiary.repository.MatchRepository;
import com.harmew.matchdiary.service.ReportsService;
import com.harmew.matchdiary.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ReportsServiceImpl implements ReportsService {

    private final MatchRepository matchRepository;

    private final TeamService teamService;

    public ReportsServiceImpl(MatchRepository matchRepository, TeamService teamService) {
        this.matchRepository = matchRepository;
        this.teamService = teamService;
    }

    public ReportsResponseDTO getAllReports(Integer id) {
        return new ReportsResponseDTO(getMatchesQuantity(id), getWinsQuantity(id), getWinsPercentage(id), teamService.getTeamById(id));
    }

    private Integer getMatchesQuantity(Integer id) {
        return matchRepository.findAllBySupportedTeamId(id).size();
    }

    private Integer getWinsQuantity(Integer id) {
        List<Match> matches = matchRepository.findAllBySupportedTeamId(id);

        int wins = 0;

        for (Match match : matches) {
            if (match.getScoreTeamOne() > match.getScoreTeamTwo() && Objects.equals(match.getTeamOne().getId(), id)) {
                wins += 1;
            } else if (match.getScoreTeamTwo() > match.getScoreTeamOne() && Objects.equals(match.getTeamTwo().getId(), id)) {
                wins += 1;
            }
        }

        return wins;
    }

    private Double getWinsPercentage(Integer id) {
        Integer matchesQuantity = getMatchesQuantity(id);
        Integer winsQuantity = getWinsQuantity(id);

        return (double) winsQuantity / matchesQuantity * 100;
    }

}
