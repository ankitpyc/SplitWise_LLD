package memoryStore;

import domainModel.User.User;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserMemoryStore {
    private Map<String, User> userStore;

    public UserMemoryStore() {
        this.userStore = new ConcurrentHashMap<>();
    }

    public void createUser(User user) {
        String userId = UUID.randomUUID().toString();
        user.setUserId(userId);
        this.userStore.put(userId, user);
    }

    public User getUser(String userId) {
        return this.userStore.get(userId);
    }

    public User updateUser(User user) {
        return this.userStore.put(user.getUserId(), user);
    }

}
