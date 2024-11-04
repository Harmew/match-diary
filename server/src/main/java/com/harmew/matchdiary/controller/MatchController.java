package com.harmew.matchdiary.controller;

import com.harmew.matchdiary.dto.match.MatchRequestDTO;
import com.harmew.matchdiary.dto.match.MatchResponseDTO;
import com.harmew.matchdiary.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/match")
public class MatchController {

    public final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<MatchResponseDTO>> getAllMatches() {
        return ResponseEntity.ok(service.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(service.getMatchById(id));
    }

    @PostMapping()
    public ResponseEntity<MatchResponseDTO> createTeam(@RequestBody MatchRequestDTO match) {
        MatchResponseDTO matchDTO = service.createMatch(match);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(matchDTO.id()).toUri();
        return ResponseEntity.created(uri).body(matchDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchResponseDTO> updateMatch(@PathVariable("id") Integer id, @RequestBody MatchRequestDTO match) {
        return ResponseEntity.ok(service.updateMatch(id, match));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable("id") Integer id) {
        service.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }

}