package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NamedQueries(
        {
            @NamedQuery(
                    name = "BattleBro.findById",
                    query = "SELECT b FROM BattleBro b WHERE b.id = :id"
            ),
            @NamedQuery(
                    name = "BattleBro.findByName",
                    query = "SELECT b FROM BattleBro b WHERE b.firstName = :name"
            ),
            @NamedQuery(
                    name = "BattleBro.findAll",
                    query = "SELECT b FROM BattleBro  b"
            )
        }
)

@Entity(name = "BattleBro")
public class BattleBro implements Serializable {
    @Id
    private String id;
    private String firstName;
    private Date recruitDate;
    private Date perishDate;
    private int level;

    public BattleBro() {
    }

    public BattleBro(String id, String lastName, Date recruitDate, Date perishDate, int level) {
        this.id = id;
        this.firstName = firstName;
        this.recruitDate = recruitDate;
        this.perishDate = perishDate;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(Date recruitDate) {
        this.recruitDate = recruitDate;
    }

    public Date getPerishDate() {
        return perishDate;
    }

    public void setPerishDate(Date perishDate) {
        this.perishDate = perishDate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
