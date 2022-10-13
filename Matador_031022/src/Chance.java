import java.util.Arrays;

public class Chance extends Field {
    protected String option;
    public Chance(int id, String label, int cost, int income) {
        super(id, label, cost, income);
    }
    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
        s+= "\n Træk et kort fra bunken. J for JA | N for NEJ";

        return s;
    }

    public String onAccept(Player p){
        //System.out.println(board.getChanceCard()+"FUCK");
        String s = Board.getChanceCard();

        return s;
    }

    public String onReject(Player p){
        return "Nå, men det er dit eget valg!";
    }

}