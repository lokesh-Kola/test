interface Transaction {
    void transfer(BankAccount toAccount, double amount);
}

abstract class BankAccount implements Transaction {
    protected String accountNumber;
    protected double balance;
    
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New balance: " + balance);
    }
    
    public abstract boolean withdraw(double amount);
    
    public void transfer(BankAccount toAccount, double amount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to " + toAccount.accountNumber);
        } else {
            System.out.println("Transfer failed! Insufficient funds or overdraft limit exceeded.");
        }
    }
}

class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    public boolean withdraw(double amount) {
        if (balance - amount >= 500) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New balance: " + balance);
            return true;
        }
        System.out.println("Withdrawal failed! Minimum 500 balance required.");
        return false;
    }
}

class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 5000;
    
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    
    public boolean withdraw(double amount) {
        if (balance - amount >= -OVERDRAFT_LIMIT) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New balance: " + balance);
            return true;
        }
        System.out.println("Withdrawal failed! Overdraft limit exceeded.");
        return false;
    }
}

public class bankingstatement{
    public static void main(String[] args) {
        BankAccount savings = new SavingsAccount("SAV123", 5000);
        BankAccount current = new CurrentAccount("CUR456", 2000);
        
        savings.deposit(1000);  
        current.withdraw(3000); 
        savings.transfer(current, 1500); 
        current.transfer(savings, 6000); 
    }
}
