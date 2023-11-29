package pan.eduard.Practice1.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable=false, updatable=false)
    private Long id;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "team_id", insertable = false, updatable = false)
    private Integer team_id;

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    public Long getPlayerId() {
        return id;
    }

    public void setPlayerId(Long id) {
        this.id = id;
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

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
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
