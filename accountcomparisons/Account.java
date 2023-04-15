package baazigames.accountcomparisons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Account implements OnlineAccount, Comparable<Account> {

    public int noOfRegularMovies;
    public int noOfExclusiveMovies;
    public String ownerName;

    public Account(int noOfRegularMovies, int noOfExclusiveMovies, String ownerName) {
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
        this.ownerName = ownerName;
    }

    public int monthlyCost() {
        return basePrice + noOfRegularMovies * regularMoviePrice + noOfExclusiveMovies * exclusiveMoviePrice;
    }

    @Override
    public int compareTo(Account o) {
        return o.monthlyCost() - this.monthlyCost();
    }

    @Override
    public String toString() {
        return "Owner is " + this.ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }

    public static void main(String[] args) {

        Account account = new Account(1, 2, "Raj");
        Account account1 = new Account(2, 3, "Arjun");
        Account account2 = new Account(3, 5, "Rahul");

        ArrayList<Account> accounts = new ArrayList<>();

        accounts.add(account);
        accounts.add(account1);
        accounts.add(account2);

        Collections.sort(accounts);

        System.out.println("Accounts by highest monthly cost are:");
        for (Account accountValue : accounts) {
            System.out.println(accountValue.ownerName + " " + accountValue.monthlyCost());
        }
    }
}
