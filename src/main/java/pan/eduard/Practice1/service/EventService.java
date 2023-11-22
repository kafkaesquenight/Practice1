package pan.eduard.Practice1.service;

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
    public void addEvent(int id, String name, LocalDate date, int event_id){
        eventRepository.insertEvent(id, name, date, event_id);
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
}