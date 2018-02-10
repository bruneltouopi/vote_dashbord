/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vote.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vote.domain.Candidate;
import com.vote.dto.VoteResultDto;
import com.vote.repository.CanditeRepository;
import com.vote.repository.VotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * L'idee de cette classe est utilise dans le cas des messages de diffusion.
 * 
 * @author eric
 */
@Service
public class WSMessageService extends TextWebSocketHandler {

	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired 
	private VotesRepository votesRepository;

	@Scheduled(cron = "*/1 * * * * ?")
	public void trigger() {
		final long time = (new Date()).getTime();
		List<VoteResultDto> resutsVotes= votesRepository.getResultElection();

		this.template.convertAndSend("/topic/votes", resutsVotes);
	}
}
