package pan.eduard.Practice1.domain;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

import java.util.Date;

@Entity
@Table(name = "my_event")
public class MyEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "event_place_id")
    @JsonIgnore
    private EventPlace eventPlace;

    public int getEventId() {
        return id;
    }

    public void setEventId(int id) {
        this.id = id;
    }

    public String getEventName() {
        return name;
    }

    public void setEventName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return date;
    }

    public void setEventDate(Date date) {
        this.date = date;
    }
}
