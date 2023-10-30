package pan.eduard.Practice1.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @OneToMany
    private List<Player> players = new ArrayList<>();

    public int getTeamId() {
        return id;
    }

    public void setTeamId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return name;
    }

    public void setTeamName(String name) {
        this.name = name;
    }

    public List<Player> getTeamPlayers() {
        return players;
    }

    public void setTeamPlayers(List<Player> players) {
        this.players = players;
    }
}
