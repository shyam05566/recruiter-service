package com.softvision.service;

import com.softvision.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CandidateService {

    Candidate addCandidate(Candidate candidate);
    Candidate findCandidateById(String id);
    void deleteCandidateById(String id);
    List<Candidate> saveAllCandidates(List<Candidate> candidates);
    Page<Candidate> findAllCandidates(Pageable pageable);
    Candidate updateCandidate(Candidate candidate, String id);
    void deleteAllCandidates();

}
