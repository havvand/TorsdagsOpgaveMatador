public class Tax extends Field{

    public Tax(int ID, String label, int cost, int income) {
        super(ID, label, cost, income);

    }

    public double calculateAssets(Player p){
        return p.netWorth()+p.getBalance();
    }

    @Override
    public String onLand(Player p) {
        String s = super.onLand(p);
        String R_B = "\033[1;31m",  R = "\033[0m";

        s += (R_B + "\n" + p.getName() + " skal betale SKAT! " + R +
                "\nVil du betale 4000 dKr hver omgang: \n Tast J. " +
                "\nVil du betale 10 procent af dine aktiver: \n Tast N.");

        return s;
    }

    protected String onAccept(Player p)
    {
        p.pay(this.cost);
        System.out.println(p.getBalance());
        return p.getName() + " betalte: " + this.cost;
    }

    protected String onReject(Player p){
        double tax = calculateAssets(p)*0.1;
        p.pay((int)tax);
        return p.getName() + " betalte: " + tax + " dKr"; //+ "\n" + p.getName() + " har " + p.getBalance() + " dKr tilbage." ;
    }
}
