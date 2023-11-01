package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.EventPlace;
import pan.eduard.Practice1.repository.EventPlaceRepository;

@Service
@Slf4j
public class EventPlaceService {
    private EventPlaceRepository eventPlaceRepository;
    @Autowired
    public EventPlaceService(EventPlaceRepository eventPlaceRepository) {
        this.eventPlaceRepository = eventPlaceRepository;
    }

    public EventPlace findEventPlaceById(int id) {
        return eventPlaceRepository.findByEventPlaceId(id);
    }
}
