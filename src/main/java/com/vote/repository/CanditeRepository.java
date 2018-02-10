package com.vote.repository;

import com.vote.domain.Candidate;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface CanditeRepository extends CrudRepository<Candidate, Long> {

}
