package XMLInterface;

import entity.Roster;

public class XMLService {

    private XMLWriter writer;
    private XMLReader reader;

    public XMLService() {
        writer = new XMLWriter();
        reader = new XMLReader();
    }

    public Roster getRosterFromXML(){
        return null;
    }

    public void updateRosterXML(Roster roster){

    }

}
