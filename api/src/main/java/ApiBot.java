import body.UserBody;
import response.UserModel;

import java.util.Comparator;
import java.util.List;

public class ApiBot {

    public ApiController controller() {
        return new ApiController();
    }

    public void createUsers(List<UserBody> users) {
        for (UserBody user : users) {
            controller().createUser(user);
        }
    }

    public void deleteAllUsers() {
        List<String> ids = getAllUsers().stream().map(d -> d.getId()).toList();
        for (String s : ids) {
            controller().deleteUser(s);
        }
    }

    public List<UserModel> getAllUsers() {
        return controller().getUsers();
    }

    public List<UserModel> sortUsersByName(List<UserModel> users) {
        return users.stream().sorted(Comparator.comparing(UserModel::getName)).toList();
    }

    public UserModel getUser(String email) {
        return controller().getUser(email);
    }

    public void createUser(UserBody user) {
        controller().createUser(user);
    }
}
