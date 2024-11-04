package com.harmew.matchdiary.controller;

import com.harmew.matchdiary.dto.team.TeamResponseDTO;
import com.harmew.matchdiary.model.Team;
import com.harmew.matchdiary.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    public final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAllTeams() {
        return "TESTE";
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getTeamById(id));
    }

    @PostMapping()
    public String addTeam(@RequestBody Team team) {
        return team.getName();
    }

    @PutMapping("/{id}")
    public String updateTeam(@PathVariable("id") Integer id, @RequestBody Team team) {
        return id + team.getName();
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(@PathVariable("id") Integer id) {
        return "" + id;
    }
}
