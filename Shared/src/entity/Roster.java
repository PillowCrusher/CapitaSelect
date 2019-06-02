package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Roster implements Serializable {
    private String campaign;
    private List<BattleBro> roster = new ArrayList<>();
    private List<BattleBro> fallen = new ArrayList<>();

    public Roster() {
    }

    public Roster(String campaign, List<BattleBro> roster, List<BattleBro> fallen) {
        this.campaign = campaign;
        this.roster = roster;
        this.fallen = fallen;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
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
