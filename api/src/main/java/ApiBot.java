import response.UserResponse;

import java.util.Comparator;
import java.util.List;

public class ApiBot {

    public ApiController controller() {
        return new ApiController();
    }


    public void deleteAllUsers() {
        List<String> ids = controller().getUsers().stream().map(d -> d.getId()).toList();
        for (String s : ids) {
            controller().deleteUser(s);
        }
    }

    public List<UserResponse> sortUsersByName(List<UserResponse> users) {
        return users.stream().sorted(Comparator.comparing(UserResponse::getName)).toList();
    }
}
