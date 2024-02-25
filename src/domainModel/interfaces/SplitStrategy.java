package domainModel.interfaces;

import domainModel.User.User;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    public Map<String, Double> splitExpense(List<User> splitBetween, List<Double> splitAmounts, Double amount);
}
