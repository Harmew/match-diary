package com.harmew.matchdiary.controller;

import com.harmew.matchdiary.model.Match;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    @GetMapping("/all")
    public String getAllMatches() {
        return "TESTE";
    }

    @GetMapping("/{id}")
    public String getMatchById(@PathVariable("id") Integer id) {
        return "" + id;
    }

    @PostMapping()
    public String addMatch(@RequestBody Match match) {
        return "";
    }

    @PutMapping("/{id}")
    public String updateMatch(@PathVariable("id") Integer id, @RequestBody Match match) {
        return "" + id;
    }

    @DeleteMapping("/{id}")
    public String deleteMatch(@PathVariable("id") Integer id) {
        return "" + id;
    }
}