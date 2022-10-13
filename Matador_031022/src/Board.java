import java.util.Arrays;

public class Board {

    private Field[] fields = new Field[40];
    private static ChanceCard[] chanceCards = new ChanceCard[10];
    static int numOfCards = 0;

    Board(String[] data, String[] chanceCards) {
        createFields(data);
        createChanceCards(chanceCards);
    }

    private Field[] createFields(String[] data) {
        for (int i = 0; i < fields.length; i++) {
            String s = data[i];
            String[] values = s.split(",");
            /*TODO: Instantiate subclasses of Field based on data. (No field is just a field)
               1. add a switch-case that looks at the type of the field to be created
               2. create the subclasses need to instiate based on the type of field. (constructor, attributes and override onString and onLand methods)
            *
            *  PSEUDO CODE:
            *
            *  Field f = null;
            *  switch(values[1])
            *  case "plot": f = new Plot(...)
            *
            */

            int id = Integer.parseInt(values[0]);
            String fieldtype = values[1];
            String label = values[2];
            int cost = Integer.parseInt(values[3].trim());
            int income = Integer.parseInt(values[4].trim());
            int seriesID = Integer.parseInt(values[5].trim());

            Field f;

            switch (fieldtype) {
                case "plot":
                    f = new Plot(id, label, cost, income, seriesID);
                    break;

                case "rederi":
                case "brewery":
                    f = new Business(id, label, cost, income, seriesID);
                    break;

                case "jail":
                    f = new Jail(id, label, cost, income);
                    break;
                case "visit":
                    f = new Visit(id, label, cost, income);
                    break;
                case "parking":
                    f = new Parking(id, label, cost, income);
                    break;
                case "start":
                    f = new Start(id, label, cost, income);
                    break;
                case "lykkefelt":
                    f = new Chance(id, label, cost, income);
                    break;
                case "tax":
                    f = new Tax(id, label, cost, income);
                    break;
                default:
                    f = new Field(id, label, cost, income);
            }

            fields[i] = f;
        }
        return fields;
    }

    public Field getField(int id) {
        id--;
        if (id < 0 || id >= fields.length) {
            return null;
        }
        return fields[id];
    }

    private ChanceCard[] createChanceCards(String[] data) {
        for (int i = 0; i < chanceCards.length; i++) {
            String s = data[i];
            String[] values = s.split(",");

            int id = Integer.parseInt(values[0]);
            String label = values[1];
            int cost = Integer.parseInt(values[2].trim());
            int income = Integer.parseInt(values[3].trim());

            ChanceCard c;
            if (id < 11) {
                c = new ChanceCard(id, label, cost, income);
            } else {
                c = new ChanceCard(id, label, cost, income);
            }
            chanceCards[i] = c;

        }
        return chanceCards;
    }

    public static String getChanceCard(){

       String s = chanceCards[numOfCards].getLabel1();
       numOfCards += 1;
       if (numOfCards == 10){
           numOfCards = 0;
       }
       return s;
    }
}