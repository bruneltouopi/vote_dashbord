package com.vote.repository;

import com.vote.domain.Votes;
import com.vote.dto.VoteResultDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VotesRepository extends CrudRepository<Votes,Long> {
    @Query("SELECT new com.vote.dto.VoteResultDto(v.candidate.name,count(v.id)) FROM Votes v GROUP BY v.candidate.id")
    List<VoteResultDto> getResultElection();
}
