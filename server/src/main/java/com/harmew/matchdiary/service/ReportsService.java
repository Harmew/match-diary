package com.harmew.matchdiary.service;

import com.harmew.matchdiary.dto.reports.ReportsResponseDTO;

public interface ReportsService {

    /**
     * Return all reports from matches
     */
    ReportsResponseDTO getAllReports(Integer id);
}
