package com.vote.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Votes implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String voter;
    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Votes(String voter, Candidate candidate) {
        this.voter = voter;
        this.candidate = candidate;
    }

    public Long getId() {
        return id;
    }

    public String getVoter() {
        return voter;
    }

    public void setVoter(String voter) {
        this.voter = voter;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "Votes{" +
                "voter='" + voter + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
