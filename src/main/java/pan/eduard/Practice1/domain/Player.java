package pan.eduard.Practice1.domain;

import jakarta.persistence.*;
import net.minidev.json.annotate.JsonIgnore;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;

    @ManyToOne
    @JoinColumn(name = "player_team_id")
    @JsonIgnore
    private Team team;

    public int getPlayerId() {
        return id;
    }

    public void setPlayerId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return name;
    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public String getPlayerNickname() {
        return nickname;
    }

    public void setPlayerNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPlayerFirst_name() {
        return first_name;
    }

    public void setPlayerFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getPlayerLast_name() {
        return last_name;
    }

    public void setPlayerLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Team getPlayerTeam() {
        return team;
    }

    public void setPlayerTeam(Team team) {
        this.team = team;
    }
}
