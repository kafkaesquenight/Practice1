package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.MyEvent;
import pan.eduard.Practice1.repository.EventRepository;

import java.util.List;

@Service
@Slf4j
public class EventService {
    private EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    public MyEvent findEventById(int id) {
        return eventRepository.findByEventId(id);
    }
    public List<MyEvent> getEvents() {
        return eventRepository.findAll();
    }
}
