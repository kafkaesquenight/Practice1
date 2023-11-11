package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.MyEvent;
import pan.eduard.Practice1.repository.EventRepository;

import java.sql.Date;
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
        return eventRepository.findAll();
    }
    public void addEvent(String name, LocalDate date, int event_id){
        eventRepository.insertEvent(name, date, event_id);
    }
    public void removeEvent(int event_id){
        eventRepository.deleteEvent(event_id);
    }
    public MyEvent findEventById(int id) {
        return eventRepository.findByEventId(id);
    }
    public MyEvent findEventByName(String name) {
        return eventRepository.findByEventName(name);
    }
}
