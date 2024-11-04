package com.harmew.matchdiary.controller;

import com.harmew.matchdiary.model.Team;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @GetMapping("/all")
    public String getAllTeams() {
        return "TESTE";
    }

    @GetMapping("/{id}")
    public String getTeamById(@PathVariable("id") Integer id) {
        return "" + id;
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
