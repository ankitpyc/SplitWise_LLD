package domainModel.User;

import java.util.Objects;

public interface ExpenseObservable {

    public void notifyObserver(ExpenseObservable expenseObservable, Object arg);
}
