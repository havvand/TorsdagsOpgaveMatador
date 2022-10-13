/* TODO: Make this class a super class by...
    1. removing attributes that are not common to ALL field types (cost, income, seriesID, owner)
    2. adding onLand, onReject and processResonse methods
*
*
* */
public class Field {
    private int ID;
    private String label;
    protected int cost;
    private int income;



    public  Field(int ID, String label, int cost, int income){
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    @Override
    public String toString() {
        return ID + ": " + label;
    }


    public String onLand(Player p){
        String col = "\033[1;33m";
        String RESET = "\033[0m";
        String s = col + p.getName()+ " er landet på " + this  + ". " + RESET;

        return s;
    }

    protected String getLabel(){
        return this.label;
    }

    public String processChoice(String choice, Player p) {
        String s;
        if(choice.equalsIgnoreCase("J")){
            s = onAccept(p);

        }else{
            s = onReject(p);

        }
        return s;
    }
    protected String onAccept(Player p){
        return "";
    }
    protected String onReject(Player p){
        return "";
    }

    public int getIncome(){
        return income;
    }


}