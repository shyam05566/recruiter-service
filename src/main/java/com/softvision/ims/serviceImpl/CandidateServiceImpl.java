package com.softvision.ims.serviceImpl;

import com.softvision.ims.entity.Candidate;
import com.softvision.ims.repository.CandidateRepository;
import com.softvision.ims.service.CandidateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Inject
    CandidateRepository candidateRepository;

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.insert(candidate);
    }

    @Override
    public Candidate findCandidateById(String id) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        if(optionalCandidate.isPresent()){
            return optionalCandidate.get();
        }
        return null;
    }

    @Override
    public void deleteCandidateById(String id) {
        candidateRepository.deleteById(id);
    }

    @Override
    public List<Candidate> saveAllCandidates(List<Candidate> candidates) {
        return candidateRepository.saveAll(candidates);
    }

    @Override
    public Page<Candidate> findAllCandidates(Pageable pageable) {
        return candidateRepository.findAll(pageable);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate, String id) {
        Optional<Candidate> optionalCandidate = candidateRepository.findById(id);
        if(optionalCandidate.isPresent()){
            candidate.setCandidateId(id);
            return candidateRepository.save(candidate);
        }
        return null;
    }

    @Override
    public void deleteAllCandidates() {
        candidateRepository.deleteAll();
    }
}
