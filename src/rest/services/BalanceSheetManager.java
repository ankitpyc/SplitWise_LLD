package rest.services;

import domainModel.ExpenseData;
import domainModel.User.Balances;
import domainModel.User.ExpenseObservable;
import domainModel.User.ExpenseObserver;
import domainModel.User.User;
import memoryStore.UserMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class BalanceSheetManager implements ExpenseObserver {
    /**
     * @param expenseObservable
     * @param arg
     */

    @Autowired
    UserMemoryStore userMemoryStore;

    @Override
    public void updateOnChange(ExpenseObservable expenseObservable, Object arg) {
        if (arg instanceof ExpenseData) {
            ExpenseData expenseData = (ExpenseData) arg;
            for (Map.Entry entry : expenseData.getUserBalances().entrySet()) {
                String userId = (String) entry.getKey();
                Double amount = (Double) entry.getValue();
                User user = userMemoryStore.getUser(userId);
                Balances balances = getBalances(expenseData, amount);
                user.getBalanceSheet().getBalances().add(balances);
                user.getBalanceSheet().calculateBalances();
            }

        }

    }

    private static Balances getBalances(ExpenseData expenseData, Double amount) {
        Balances balances = new Balances();
        balances.setTotalAmount(-1 * amount);
        balances.setUser(expenseData.getUserpaidBy());
        return balances;
    }
}
