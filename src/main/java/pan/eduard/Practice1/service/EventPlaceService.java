package pan.eduard.Practice1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pan.eduard.Practice1.domain.EventPlace;
import pan.eduard.Practice1.repository.EventPlaceRepository;

import java.util.List;

@Service
@Slf4j
public class EventPlaceService {
    private EventPlaceRepository eventPlaceRepository;
    @Autowired
    public EventPlaceService(EventPlaceRepository eventPlaceRepository) {
        this.eventPlaceRepository = eventPlaceRepository;
    }
    public List<EventPlace> getEventPlaces() {
        return eventPlaceRepository.findAllEventPlaceNative();
    }
    public void addEventPlace(int id, String name, String country, String city){
        eventPlaceRepository.insertEventPlace(id, name, country, city);
    }
    public void removeEventPlace(int id){
        eventPlaceRepository.deleteById(id);
    }
    public EventPlace findEventPlaceById(int id) {
        return eventPlaceRepository.retrieveById(id);
    }
    public EventPlace findEventPlaceByName(String name) {
        return eventPlaceRepository.retrieveByName(name);
    }

}