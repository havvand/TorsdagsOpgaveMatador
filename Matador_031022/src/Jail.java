public class Jail extends Field{

    public Jail(int ID, String label, int cost, int income){
        super(ID, label, cost, 0);
    }

    public String onLand(Player p)
    {
        String s = super.onLand(p);

        s += "Du skal i fængsel. Du modtager IKKE 4000 dKr når du passerer start.";

        /* TODO: Der skal skrives kode som sikre:
                 1) at man ikke modtager de 4000 for at passerer start.
                 2) at man kan betale 1000 dKr inden man kaster terningerne for at komme ud.
                  */

        return s;

    }
}
