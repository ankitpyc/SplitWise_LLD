package domainModel.Groups;

import domainModel.interfaces.SplitStrategy;
import domainModel.User.User;

import java.util.List;


public class Expense {
    private String expenseId;
    private User paidBy;
    private List<User> splitBetween;
    private SplitStrategy splitStrategy;
    private Double amount;

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public List<User> getSplitBetween() {
        return splitBetween;
    }

    public void setSplitBetween(List<User> splitBetween) {
        this.splitBetween = splitBetween;
    }

    public SplitStrategy getSplitStrategy() {
        return splitStrategy;
    }

    public void setSplitStrategy(SplitStrategy splitStrategy) {
        this.splitStrategy = splitStrategy;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }


}
