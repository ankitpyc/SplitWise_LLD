package rest.services;

import domainModel.User.BalanceSheet;
import domainModel.User.Balances;
import domainModel.User.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class TransactionManager {

    List<Balances> balances = new ArrayList<>();

    public List<Balances> getAllTransactions(User user, BalanceSheet balanceSheet) {

        Map<String, Double> netBalances = new HashMap<>();
        List<Balances> resultBalances = new ArrayList<>();

        // Calculate net balances for each user
        for (Balances balance : balanceSheet.getBalances()) {
            String userName = balance.getUser().getUserId();
            netBalances.put(userName, netBalances.getOrDefault(userName, 0.0) + balance.getTotalAmount());
        }

        int count = 0;

        while (true) {
            String payer = null;
            String payee = null;

            for (Map.Entry<String, Double> entry : netBalances.entrySet()) {
                if (entry.getValue() < 0) {
                    payer = entry.getKey();
                    break;
                }
            }

            for (Map.Entry<String, Double> entry : netBalances.entrySet()) {
                if (entry.getValue() > 0) {
                    payee = entry.getKey();
                    break;
                }
            }

            if (payer == null || payee == null) {
                break; // No more transactions needed
            }

            double amount = Math.min(Math.abs(netBalances.get(payer)), Math.abs(netBalances.get(payee)));

            netBalances.put(payer, netBalances.get(payer) + amount);
            netBalances.put(payee, netBalances.get(payee) - amount);
            if (payer == user.getUserId()) {
                resultBalances.add(new Balances(-1 * amount, new User(payee)));
            }

            if (payee == user.getUserId()) {
                resultBalances.add(new Balances(amount, new User(payer)));
            }
        }

        return resultBalances;
    }

    private void createAndReturnBalances(Map<User, Double> amountsOwed, Map<User, Double> amountsToCollect) {


        Balances balancess;

        if (amountsOwed != null) {
            for (Map.Entry entry : amountsOwed.entrySet()) {
                User user = (User) entry.getKey();
                Double amount = (Double) entry.getValue();
                if (Math.abs(amount.doubleValue()) == 0) continue;
                balancess = new Balances();
                balancess.setUser(user);
                balancess.setTotalAmount(-1 * amount);
                balances.add(balancess);
            }
        }

        if (amountsToCollect != null) {
            for (Map.Entry entry : amountsToCollect.entrySet()) {
                User user = (User) entry.getKey();
                Double amount = (Double) entry.getValue();
                if (Math.abs(amount.doubleValue()) == 0) continue;
                balancess = new Balances();
                balancess.setUser(user);
                balancess.setTotalAmount(amount);
                balances.add(balancess);

            }
        }
    }


}
