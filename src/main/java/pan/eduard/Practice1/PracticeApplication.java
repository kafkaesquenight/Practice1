package pan.eduard.Practice1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pan.eduard.Practice1.service.EventService;
import pan.eduard.Practice1.service.PlayerService;
import pan.eduard.Practice1.service.ServiceD;

@SpringBootApplication
@Slf4j
public class PracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PracticeApplication.class, args);
		EventService eventService = ctx.getBean("eventService", EventService.class);
		log.info("Events in database: {}", eventService.getEvents());
		log.info("findEventById 2 in database: {}", eventService.findEventById(2));
	}
}

