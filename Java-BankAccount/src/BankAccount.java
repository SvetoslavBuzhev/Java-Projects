public class BankAccount {
    private String name;
    private Id id;
    private int previousAmountDeposit;
    private int previousAmountWithdraw;

    private int balance;

    public BankAccount(String name, String id) {
        setName(name);
        setId(id);
        this.balance = 0;
    }

    public void withdraw(int withdrewMoney) {
        if (balance - withdrewMoney < 0) {
            throw new IllegalArgumentException("Not enough money!");
        }
        this.balance -= withdrewMoney;
        previousAmountWithdraw = withdrewMoney;
        System.out.println("You withdrew " + withdrewMoney + " pounds.");
    }

    public void Deposit(int depositMoney) {
        if (depositMoney <= 0) {
            throw new IllegalArgumentException("Invalid deposit transaction!");
        }
        this.balance += depositMoney;
        previousAmountDeposit = depositMoney;
        System.out.println("You deposited " + depositMoney + " pounds!");
    }

    public int getPrevious(String transaction){
        int money = 0;
        if (transaction.equals("Deposit")){
            money = previousAmountDeposit;
        } else if (transaction.equals("Withdraw")) {
            money=previousAmountWithdraw;
        }
        return money;
    }

    public int getBalance(){
        return balance;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid name!");
        }
        this.name = name;
    }

    private void setId(String id) {
        try {
            this.id = new Id(id);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

}
