import java.util.ArrayList;

public class Player {
    private String name;
    private BankAccount account;
    private int startPosition = 1;
    private int currentPosition = startPosition;
    private ArrayList<Property> deeds = new ArrayList();


    public Player(String name, int amount) {
        this.name = name;
        account = new BankAccount(amount);
    }

    public void addDeed(Property property){
        deeds.add(property);
        System.out.println("Array" + deeds);
    }

    public double netWorth(){
        double netWorth = 0;
        for (Property s: deeds) {
            netWorth += s.cost;
        }
        return netWorth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return account.getBalance();
    }

    @Override
    public String toString() {
        return name + ":"+ account;

    }

    public void buy(int cost){

        this.account.doTransAction(cost);
    }

    public void pay(int cost) {
        this.account.doTransAction(cost);
    }

    public int updatePos(int sum){

        currentPosition = currentPosition + sum;//52
        if(currentPosition >40){
            //this.recevie(board.getField(1).getIncome) --- SKal laves såå man får penge når man passerer start.
            currentPosition -= 40;//currentPosition = currentPosition -40
        }
        return currentPosition;
    }

    public int getPosition() {
        return currentPosition;
    }


}