package domainModel.User;

public interface ExpenseObserver {
    public void updateOnChange(ExpenseObservable expenseObservable,Object arg);
}
