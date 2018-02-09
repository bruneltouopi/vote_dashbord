/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private UserRepository userRepository;

	@Scheduled(cron = "*/1 * * * * ?")
	public void trigger() {
		final long time = (new Date()).getTime();
		Iterable<User> usersIter=userRepository.findAll();
		List<User> users = new ArrayList<>(); 
		usersIter.forEach(user -> users.add(user) );

		this.template.convertAndSend("/topic/greetings",users);
	}
}
