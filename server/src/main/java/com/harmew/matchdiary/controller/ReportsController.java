package com.harmew.matchdiary.controller;

import com.harmew.matchdiary.dto.reports.ReportsResponseDTO;
import com.harmew.matchdiary.service.ReportsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    private final ReportsService service;

    public ReportsController(ReportsService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportsResponseDTO> getReports(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getAllReports(id));
    }
}
