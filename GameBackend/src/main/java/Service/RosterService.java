package Service;

import Dao.RosterDao;
import Entity.Roster;

import javax.inject.Inject;

public class RosterService {

    @Inject
    private RosterDao rosterDao;

    public Roster getCurrentRoster() {
        return rosterDao.getCurrentRoster();
    }

    public Roster newCampaign() {
        Roster roster = new Roster();
        rosterDao.createRoster(roster);
        return getCurrentRoster();
    }

    public Roster updateRoster(Roster roster) {

        return getCurrentRoster();
    }
}
