package com.manager.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Timer {

	@Scheduled(cron = "0 0 3 * * ?")
	public void clientInfoTimer() { 
		System.out.println("---------i am coming!!------------");
	}
}
