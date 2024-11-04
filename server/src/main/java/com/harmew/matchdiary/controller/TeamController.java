package com.harmew.matchdiary.controller;

import com.harmew.matchdiary.dto.team.TeamRequestDTO;
import com.harmew.matchdiary.dto.team.TeamResponseDTO;
import com.harmew.matchdiary.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    public final TeamService service;

    public TeamController(TeamService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamResponseDTO>> getAllTeams() {
        return ResponseEntity.ok(service.getAllTeams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getTeamById(id));
    }

    @PostMapping()
    public ResponseEntity<TeamResponseDTO> createTeam(@RequestBody TeamRequestDTO team) {
        TeamResponseDTO teamDTO = service.createTeam(team);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(teamDTO.id()).toUri();
        return ResponseEntity.created(uri).body(teamDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> updateTeam(@PathVariable("id") Integer id, @RequestBody TeamRequestDTO team) {
        return ResponseEntity.ok(service.updateTeam(id, team));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable("id") Integer id) {
        service.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
