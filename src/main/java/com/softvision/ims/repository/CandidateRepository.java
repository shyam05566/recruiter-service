package com.softvision.ims.repository;

import com.softvision.ims.entity.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends MongoRepository<Candidate, String> {
    //Candidate findCandidateById(String id);
}
