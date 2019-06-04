package Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "BattleBro")
public class BattleBro implements Serializable {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private Date recruitDate;
    private Date perishDate;
    private int level;

    public BattleBro() {
    }

    public BattleBro(String id,String firstName, String lastName, Date recruitDate, Date perishDate, int level) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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