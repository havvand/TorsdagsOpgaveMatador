public class Property extends  Field{
    String W = "\033[1;97m";
    String G = "\033[1;32m";
    String RESET = "\033[0m";

    protected int seriesID;
    protected Player owner;
    protected String option;

    public Property(int ID, String label, int cost, int income, int seriesID) {
        super(ID, label, cost, income);
        this.seriesID = seriesID;
    }

    @Override
    public String toString() {
        String s = super.toString();
        return s+" tilhører serie: "+this.seriesID;
    }
    @Override
    public String onLand(Player p){
        String s = super.onLand(p);
        if (this.owner == null){
            option = "buy";
            s += G + "\nVil du købe "+this.getLabel()+" til " + this.cost + " dkr." + W + " Tast J for ja | N for nej." + RESET;

        } else {
            option = "payRent";
            s += "\nDu er landet på " + this.getLabel() + " som ejes af " + this.owner.getName() + "." + "\nVil du betale husleje på " + getIncome();
        }
        return s;
    }
    @Override
    protected String onAccept(Player p){
        String s = "";

        if(option.equals("buy")){
            s = "Grunden er din!";

            p.buy(this.cost);
            p.addDeed(Property.this);
            //p.addDeed(this);
            this.owner = p;
        } else if(option.equals("payRent"))
        {
            p.pay(getIncome());
            owner.pay(-getIncome());
            s = "Du har betalt. " + owner.getName() + "'s nye balance: " + owner.getBalance();
        }
        return s;
    }
    @Override
    protected String onReject(Player p){
        return G + "Du købet ikke " + this.getLabel() + "." + RESET;
    }

}