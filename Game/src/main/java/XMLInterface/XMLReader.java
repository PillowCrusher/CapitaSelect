package XMLInterface;

import com.owlike.genson.Genson;
import Entity.Roster;
import org.apache.camel.util.FileUtil;

import java.io.*;

public class XMLReader {
    final static private String saveLocation = "C:\\Users\\Jeroen\\IdeaProjects\\CapitaSelect\\Game\\src\\GameStorage\\Save.sav";
    private Genson serializer;
    private File file;


    public XMLReader(){
        serializer = new Genson();
        file = new File(saveLocation);
        if(!file.exists()){
            try {
                FileUtil.createNewFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Roster readRoster() throws IOException {
        InputStream inputStream = new FileInputStream(file);
        String json = readFromInputStream(inputStream);
        return serializer.deserialize(json, Roster.class);
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line);
            }
        }
        return resultStringBuilder.toString();
    }
}
