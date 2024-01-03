package pan.eduard.Practice1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import pan.eduard.Practice1.service.*;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories("pan.eduard.Practice1")
public class PracticeApplication {

	public static void main(String[] args) throws InterruptedException{
		ConfigurableApplicationContext ctx = SpringApplication. run(PracticeApplication.class, args);
		EventService eventService = ctx.getBean("eventService", EventService.class);
		EventPlaceService eventPlaceService = ctx.getBean("eventPlaceService", EventPlaceService.class);
		PlayerService playerService = ctx.getBean("playerService", PlayerService.class);
		TeamService teamService = ctx.getBean("teamService", TeamService.class);
		Thread thread = new Thread(new SomeClass());
		thread.start();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.execute(new SomeClass());
		executor.submit(new AnotherClass());
//		Thread thread = new Thread(() -> {
//			log.info("start call runnable method");
//			Stream.iterate(0, n -> n + 1).limit(10).forEach(x -> {
//				log.info("making operation with id: " + x);
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					throw new RuntimeException(e);}
//			});
//			log.info("end call runnable method");
//		});
//		thread.start();
		eventService.addEvent("Pelmeshki", LocalDate.now(), 6);
		eventService.removeEvent(6);
		log.info("Events in database: {}", eventService.getEvents());
		log.info("findEventById 2 in database: {}", eventService.findEventById(2));
		log.info("findEventByName PGL Major Kraków 2017 in database: {}", eventService.findEventByName("PGL Major Kraków 2017"));
		eventPlaceService.addEventPlace("Almaty Arena", "Kazakhstan", "Almaty");
		eventPlaceService.removeEventPlace(6);
		log.info("Event Places in database: {}", eventPlaceService.getEventPlaces());
		log.info("findEventPlaceById 2 in database: {}", eventPlaceService.findEventPlaceById(2));
		log.info("findEventPlaceByName Fox Theatre in database: {}", eventPlaceService.findEventPlaceByName("Fox Theatre"));
		playerService.addPlayer( "dev1ce", "Nicolai", "Reedtz", 1);
		playerService.removePlayerById(4);
		log.info("Players in database: {}", playerService.getPlayers());
		log.info("findPlayerById 3 in database: {}", playerService.findPlayerById(3));
		log.info("findPlayerByFirstName Sharipov in database: {}", playerService.findPlayerByFirstName("Sharipov"));
		teamService.addTeam(6, "Balls");
		teamService.removeTeamById(6);
		log.info("Teams in database: {}", teamService.getTeams());
		log.info("findTeamById 1 in database: {}", teamService.findTeamById(1));
		log.info("findTeamByName Astralis in database: {}", teamService.findTeamByName("Astralis"));
		thread.join();
	}
}

