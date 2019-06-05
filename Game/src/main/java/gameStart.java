import Entity.BattleBro;
import Entity.Roster;
import Service.BroService;
import Service.RosterService;
import XMLInterface.XMLService;

public class gameStart {

    public static void main(String[] args) {

        RosterService rosterService = new RosterService();
        System.out.println("n for new brother");
        System.out.println("k for kill brother");
        System.out.println("r for rename brother");
        System.out.println("l to level a random brother");
        System.out.println("nn to start a new campaign");
        while (true){
            System.out.println("Do someting");

        }
    }
}
