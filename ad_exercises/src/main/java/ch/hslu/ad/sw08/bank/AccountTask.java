package ch.hslu.ad.sw08.bank;

import java.util.List;
import java.util.concurrent.Callable;

public class AccountTask implements Callable<Boolean> {

    private BankAccount from;
    private BankAccount to;
    private int amount;

    public AccountTask(BankAccount from, BankAccount to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    @Override
    public Boolean call() throws Exception {
        from.transfer(to, amount);
        to.transfer(from, amount);

        return true;
    }
}
