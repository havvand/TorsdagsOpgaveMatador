public class BankAccount
{
    private int balance;

    public BankAccount(int startAmount)
    {
        balance = startAmount;
    }

    public void doTransAction(int cost)
    {
        // doTransAction adds int cost to the variable this.balance.
        this.balance -= cost;
    }

    public int getBalance()
    {
        return balance;
    }

    @Override
    public String toString() {
        return "Balance: " + balance + ".";
    }
}
