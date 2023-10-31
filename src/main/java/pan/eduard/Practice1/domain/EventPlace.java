package pan.eduard.Practice1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event_place")
public class EventPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @OneToMany
    private List<MyEvent> events = new ArrayList<>();

    public int getPlaceId() {
        return id;
    }

    public void setPlaceId(int id) {
        this.id = id;
    }

    public String getPlaceName() {
        return name;
    }

    public void setPlaceName(String name) {
        this.name = name;
    }

    public String getPlaceCountry() {
        return country;
    }

    public void setPlaceCountry(String country) {
        this.country = country;
    }

    public String getPlaceCity() {
        return city;
    }

    public void setPlaceCity(String city) {
        this.city = city;
    }

    public List<MyEvent> getMyEvents() {
        return events;
    }

    public void setMyEvents(List<MyEvent> events) {
        this.events = events;
    }
}
