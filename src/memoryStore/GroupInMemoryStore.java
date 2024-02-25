package memoryStore;

import domainModel.Groups.Groups;
import domainModel.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class GroupInMemoryStore {

    @Autowired
    UserMemoryStore userMemoryStore;
    Map<String, Groups> groupMemoryStore;

    public GroupInMemoryStore() {
        this.groupMemoryStore = new ConcurrentHashMap<>();
    }

    public void addGroup(Groups groups) {
        String groupId = UUID.randomUUID().toString();
        groupMemoryStore.put(UUID.randomUUID().toString(), groups);

        for (User user : groups.getMembers()) {
            User member = userMemoryStore.getUser(user.getUserId());
            List<String> groupsList = member.getGroups().isEmpty() ? new ArrayList<>() : member.getGroups();
            groupsList.add(groupId);
            user.setGroups(groupsList);
            userMemoryStore.updateUser(user);
        }
    }

    public Groups getGroup(String groupID) {
       return groupMemoryStore.get(groupID);
    }
}
