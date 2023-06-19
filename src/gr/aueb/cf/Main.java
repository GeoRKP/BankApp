package gr.aueb.cf;

import gr.aueb.cf.exceptions.InsufficientBalanceException;
import gr.aueb.cf.exceptions.NegativeAmountException;
import gr.aueb.cf.exceptions.SsnNotValidException;
import gr.aueb.cf.model.Account;
import gr.aueb.cf.model.OverdraftAccount;
import gr.aueb.cf.model.OverdraftJointAccount;
import gr.aueb.cf.model.User;

public class Main {

    public static void main(String[] args) {
        User geo = new User("Geo.", "Kapatsinas", "12345");
        Account account = new Account(geo, "GR12345", 100);
        Account overGeo = new OverdraftAccount(geo, "GR23456", 50);
        User anna = new User("Anna", "G.", "56789");

        try {
            System.out.println("Account: \n" + account);
            System.out.println("Overdraft : \n" + overGeo);

            Account overJointAccount = new OverdraftJointAccount(geo, "GR23459" , 200.50, anna);
            overJointAccount.deposit(100);
            overJointAccount.withdraw(50, "56789");

            System.out.println("Overdraft joint account: \n" + overJointAccount);
        } catch (NegativeAmountException | InsufficientBalanceException | SsnNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
