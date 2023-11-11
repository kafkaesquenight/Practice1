package pan.eduard.Practice1;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pan.eduard.Practice1.service.EventPlaceService;
import pan.eduard.Practice1.service.EventService;
import pan.eduard.Practice1.service.PlayerService;
import pan.eduard.Practice1.service.ServiceD;

import java.time.LocalDate;

@SpringBootApplication
@Slf4j
public class PracticeApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(PracticeApplication.class, args);
		EventService eventService = ctx.getBean("eventService", EventService.class);
		eventService.addEvent("Pelmeshki", LocalDate.now(), 6);
		eventService.removeEvent(6);
		log.info("Events in database: {}", eventService.getEvents());
		log.info("findEventById 2 in database: {}", eventService.findEventById(2));
		log.info("findEventByName PGL Major Kraków 2017 in database: {}", eventService.findEventByName("PGL Major Kraków 2017"));
		EventPlaceService eventPlaceService = ctx.getBean("eventPlaceService", EventPlaceService.class);
		eventPlaceService.addEventPlace(6, "Almaty Arena", "Kazakhstan", "Almaty");
		eventPlaceService.removeEventPlace(6);
		log.info("Event Places in database: {}", eventPlaceService.getEventPlaces());
		log.info("findEventPlaceById 2 in database: {}", eventPlaceService.findEventPlaceById(2));
		log.info("findEventPlaceByName Fox Theatre in database: {}", eventPlaceService.findEventPlaceByName("Fox Theatre"));
		PlayerService playerService = ctx.getBean("playerService", PlayerService.class);
		playerService.addPlayer(6, "dev1ce", "Nicolai", "Reedtz", 1);
		log.info("Players in database: {}", playerService.findAll());
		log.info("findPlayerById 3 in database: {}", playerService.findPlayerById(3));
		log.info("findPlayerByNickname dev1ce in database: {}", playerService.findPlayerByNickname("dev1ce"));
	}
}

