package domainModel.SplitStrategies;

import domainModel.interfaces.SplitStrategy;
import domainModel.User.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplit implements SplitStrategy {
    /**
     * @param splitBetween Users between which amount needs to be splitted
     * @param splitAmounts The way amount is to be splitted
     * @return Map<User,Double> distribution between different people
     */
    @Override
    public Map<String, Double> splitExpense(List<User> splitBetween, List<Double> splitAmounts,Double amount) {
        Map<String,Double> splittedAmounts = new HashMap<>();
        Double splitAmount = (Double) (amount/splitBetween.size());
        for(User user:splitBetween){
            splittedAmounts.put(user.getUserId(),splitAmount);
        }
        return splittedAmounts;
    }
}
