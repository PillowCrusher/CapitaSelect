package Service;

import Entity.Roster;
import XMLInterface.XMLService;

import java.util.UUID;

public class RosterService {

    private XMLService xmlService;
    private BroService broService;

    private Roster currentRoster;

    public RosterService() {
        xmlService = new XMLService();
        broService = new BroService();

        currentRoster = readRoster();
    }

    public void saveRoster(){
        if(currentRoster.getId()==null){
            currentRoster.setId(generateUUID());
        }
        xmlService.updateRosterXML(currentRoster);
    }

    public Roster readRoster() {
        return xmlService.getRosterFromXML();
    }

    public void createNewBro() {
        currentRoster.getRoster().add(broService.createBro());
    }

    public void nameRandomBro() {

    }

    public void

    private String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
