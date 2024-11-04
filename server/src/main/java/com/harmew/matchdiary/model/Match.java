package com.harmew.matchdiary.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.harmew.matchdiary.dto.match.MatchRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;

@Entity(name = "match")
@Table(name = "tb_match")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Match implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Instant date;

    @Column(name = "score_team_one")
    private Integer scoreTeamOne;

    @Column(name = "score_team_two")
    private Integer scoreTeamTwo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_one_id")
    private Team teamOne;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_two_id")
    private Team teamTwo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_supported_id")
    private Team supportedTeam;

    public Match(MatchRequestDTO data, Team teamOne, Team teamTwo, Team supportedTeam) {
        this.date = data.date();
        this.scoreTeamOne = data.scoreTeamOne();
        this.scoreTeamTwo = data.scoreTeamTwo();
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.supportedTeam = supportedTeam;
    }

}
