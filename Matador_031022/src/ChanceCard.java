import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChanceCard {
    private int ID, cost, income;
    private String label;
    public ChanceCard(int ID, String label, int cost, int income)
    {
        this.ID = ID;
        this.label = label;
        this.cost = cost;
        this.income = income;
    }

    public String getLabel1(){
        return this.label;
    }

    public int getCost(){
        return cost;
    }

    public int getIncome(){
        return income;
    }
}
