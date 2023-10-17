package org.example.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTest {
    @Scheduled(cron = "0 0/5 * * * ?")
    public void scheduleTest() {

        Logger logger = LoggerFactory.getLogger(ScheduleTest.class);

        logger.trace("----trace------");
        logger.debug("----debug------");
        logger.warn("----warn------");
        logger.info("----info------");
        logger.error("----error------");
    }
}
