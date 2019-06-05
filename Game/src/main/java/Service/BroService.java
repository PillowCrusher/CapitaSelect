package Service;

import Entity.BattleBro;

import java.util.Calendar;
import java.util.UUID;

public class BroService {

    public BroService(){

    }

    public BattleBro createBro(){
        BattleBro battleBro = new BattleBro();
        battleBro.setId(generateUUID());
        battleBro.setFirstName("unnamed");
        battleBro.setLevel(1);
        battleBro.setRecruitDate(Calendar.getInstance().getTime());
        return battleBro;
    }

    public BattleBro killBro(BattleBro battleBro) {
        battleBro.setPerishDate(Calendar.getInstance().getTime());
        return battleBro;
    }

    public BattleBro levelBro(BattleBro battleBro) {
        battleBro.setLevel(battleBro.getLevel()+1);
        return battleBro;
    }

    public BattleBro nameBro(BattleBro battleBro,String name) {
        battleBro.setFirstName(name);
        return battleBro;
    }

    private String generateUUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
