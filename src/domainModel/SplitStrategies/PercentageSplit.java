package domainModel.SplitStrategies;

import domainModel.interfaces.SplitStrategy;
import domainModel.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentageSplit implements SplitStrategy {
    /**
     * @param splitBetween Users between which amount needs to be splitted
     * @param splitAmounts The percentage for each user to be spltitted between
     * @return Map<User, Double> distribution between different people
     */
    @Override
    public Map<User, Double> splitExpense(List<User> splitBetween, List<Double> splitAmounts, Double amount) {
        Map<User, Double> splittedAmounts = new HashMap<>();
        Double totalAmount = amount;
        for (int i = 0; i < splitBetween.size(); i++) {
            User user = splitBetween.get(i);
            Double sharedAmount = (totalAmount * (splitAmounts.get(i))) / 100.0;
            splittedAmounts.put(user, sharedAmount);
        }
        return splittedAmounts;
    }
}
