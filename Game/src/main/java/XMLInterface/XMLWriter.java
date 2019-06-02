package XMLInterface;

import com.owlike.genson.Genson;
import entity.Roster;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter {
    private BufferedWriter writer;
    private static final String saveLocation =  "Game/src/GameStorage/Save.sav";
    private Genson serializer;

    public XMLWriter() {
        serializer = new Genson();
    }


    public void writeRoster(Roster roster) throws IOException {
        writer = new BufferedWriter(new FileWriter(saveLocation));
        String json = serializer.serialize(roster);
        writer.write(json);
        writer.close();
    }
}
