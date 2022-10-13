public class Plot extends Property  {

    public Plot(int ID, String label, int cost, int income, int seriesID){
        super(ID, label,cost, income, seriesID); // Calls the constructor in Property, so the "Field" can be created, and the subclass can be "added".
    }


}