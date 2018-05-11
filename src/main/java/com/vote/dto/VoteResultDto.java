package com.vote.dto;

public class VoteResultDto {
    private String candidateName;
    private Long numbers;


    public VoteResultDto(String candidateName, Long numbers) {
        this.candidateName = candidateName;
        this.numbers = numbers;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }
}
