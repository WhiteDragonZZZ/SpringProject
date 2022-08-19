package com.example.finalspring.MyConfig;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class ScheduleConfig {
	Logger logger = Logger.getLogger("ScheduleConfig");

	@Scheduled(fixedRate = 20000)
	public void Schedule() {
		logger.info("FixedRate is run");
	}

	@Scheduled(fixedDelay = 10000)
	public void ScheduleDelay() {
		logger.info("FixedDelay is run");
	}

	@Scheduled(initialDelay = 10000,fixedDelay = 10000)
	public void ScheduleInitialDelay() {
		logger.info("FixedInitialDelay is run");
	}

	@Scheduled(cron = "0/15 * * * * *")
	public void ScheduledCron() {
		logger.info("Cron work");
	}

}
