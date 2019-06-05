package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@NamedQueries(
        {
                @NamedQuery(
                        name = "Roster.get",
                        query = "SELECT r FROM Roster r"
                ),
                @NamedQuery(
                        name = "Roster.removeAll",
                        query = "DELETE FROM Roster r"
                )
        }
)
@Entity(name = "Roster")
public class Roster implements Serializable {
    @Id
    private String id;
    @OneToMany
    private List<BattleBro> roster = new ArrayList<>();
    @OneToMany
    private List<BattleBro> fallen = new ArrayList<>();

    public Roster() {
    }

    public Roster(List<BattleBro> roster, List<BattleBro> fallen) {
        this.roster = roster;
        this.fallen = fallen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BattleBro> getRoster() {
        return roster;
    }

    public void setRoster(List<BattleBro> roster) {
        this.roster = roster;
    }

    public List<BattleBro> getFallen() {
        return fallen;
    }

    public void setFallen(List<BattleBro> fallen) {
        this.fallen = fallen;
    }
}
