package pan.eduard.Practice1.service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.MyEvent;
import pan.eduard.Practice1.repository.EventRepository;
import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public List<MyEvent> getEvents() {
        return eventRepository.findAllEventsNative();
    }
    public void addEvent(String name, LocalDate date, int event_id){
        MyEvent event = MyEvent.builder().name(name).date(date).place_id(event_id).build();
        eventRepository.save(event);
    }
    public void removeEvent(int event_id){
        eventRepository.deleteById(event_id);
    }
    public MyEvent findEventById(int id) {
        return eventRepository.retrieveById(id);
    }
    public MyEvent findEventByName(String name) {
        return eventRepository.retrieveByName(name);
    }
    @Transactional
    public void truncateTable() {
        eventRepository.truncateMable();
    }
}