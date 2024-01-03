package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.EventPlace;
import pan.eduard.Practice1.domain.Player;

@Service
@Slf4j
public class FourClass {
    private PlayerService playerService;

    private EventPlaceService eventPlaceService;

    @Autowired
    public FourClass(PlayerService playerService, EventPlaceService eventPlaceService) {
        this.playerService = playerService;
        this.eventPlaceService = eventPlaceService;
    }



      @Scheduled(fixedDelay = 6000 )
     public void fixedDelayTask(){
         Iterable<Player> players = playerService.getPlayers();
         log.info("all players:{}", players);
      }

//    @Scheduled(fixedRate = 6000)
//    public void fixedRateTask(){
//        Iterable<Player> players = playerService.getPlayers();
//        log.info("all players:{}", players);
//     }

     @Async
     @Scheduled(fixedRate = 2000)
     public void fixedRateTask() {
        Iterable<Player> players = playerService.getPlayers();
         log.info("all players:{}", players);
    }

    @Scheduled(cron = "0/15 * * * * ?")
    public void cronExpressionDo(){
        Iterable<Player> players = playerService.getPlayers();
        Iterable<EventPlace> eventPlaces = eventPlaceService.getEventPlaces();
        int x = 0;
        while (x < 20) {
            if (x % 2 == 0) {
                log.info("all players there:{}", players);
            } else if (x % 2 != 0) {
                log.info("all places there:{}", eventPlaces);
            }
            x++;
        }
    }

}
