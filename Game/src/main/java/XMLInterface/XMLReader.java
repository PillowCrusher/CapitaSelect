package XMLInterface;

import com.owlike.genson.Genson;
import entity.Roster;
import org.apache.camel.util.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class XMLReader {
    final static private String saveLocation = "Game/src/GameStorage/Save.sav";
    private Genson serializer;
    private File file;


    public XMLReader(){
        File file = new File(saveLocation);
        if(file.exists()){
            try {
                FileUtil.createNewFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Roster readRoster(){
        return null;
    }
}
