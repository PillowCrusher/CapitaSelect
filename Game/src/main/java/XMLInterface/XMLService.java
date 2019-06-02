package XMLInterface;

import entity.Roster;

import java.io.IOException;

public class XMLService {

    private XMLWriter writer;
    private XMLReader reader;

    public XMLService() {
        writer = new XMLWriter();
        reader = new XMLReader();
    }

    public Roster getRosterFromXML(){
        try {
            return reader.readRoster();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateRosterXML(Roster roster){
        try {
            writer.writeRoster(roster);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
