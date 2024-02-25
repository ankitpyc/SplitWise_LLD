package rest.services;

import domainModel.Groups.Expense;
import domainModel.User.ExpenseObservable;
import domainModel.User.ExpenseObserver;
import domainModel.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import domainModel.ExpenseData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExpenseService implements ExpenseObservable {

    List<ExpenseObserver> expenseObservers = new ArrayList<>();

    @Autowired
    BalanceSheetManager balanceSheetManager;

    public ExpenseService() {
        this.expenseObservers.add(balanceSheetManager);
    }

    public void calculateAndUpdateExpense(Expense expense) {
        List<User> sharedAmongst = expense.getSplitBetween();
        Map<String, Double> splitAmount = expense.getSplitStrategy()
                .splitExpense(sharedAmongst, new ArrayList<>(), expense.getAmount());
        ExpenseData expenseData = new ExpenseData();
        expenseData.setUserpaidBy(expense.getPaidBy());
        expenseData.setUserBalances(splitAmount);
        updateUserDetails(expenseData);
    }

    private void updateUserDetails(ExpenseData expenseData) {
        notifyObserver(this, expenseData);
    }


    /**
     * @param expenseObservable
     * @param arg
     */
    @Override
    public void notifyObserver(ExpenseObservable expenseObservable, Object arg) {
        for (ExpenseObserver expenseObserver : expenseObservers) {
            expenseObserver.updateOnChange(this, arg);
        }
    }
}
