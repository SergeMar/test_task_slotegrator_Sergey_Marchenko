import body.UserBody;
import org.junit.jupiter.api.Test;
import response.LoginResponse;
import response.UserResponse;

import java.util.Comparator;
import java.util.List;

import static data.DataUser.usersData;
import static org.assertj.core.api.Assertions.assertThat;

public class AutomationTest extends TestBase {

    @Test
    void getAccessTokenTest() {
        LoginResponse response = api.controller().login();
        assertThat(response.getAccessToken()).isNotNull();
    }

    @Test
    void registerPlayersTest() {
        usersData().forEach(user -> api.controller().createUser(user));
        List<UserResponse> usersResponse = api.controller().getUsers();
        assertThat(usersResponse.size()).isEqualTo(usersData().size());
    }

    @Test
    void getAndVerifyUserTest() {
        UserBody userBody = usersData().get(0);
        api.controller().createUser(userBody);
        UserResponse userResponse = api.controller().getUser(userBody.getEmail());
        assertThat(userResponse).isEqualTo(userBody.toResponse());
    }

    @Test
    void getAndSortPlayersTest(){
        usersData().forEach(user -> api.controller().createUser(user));
        List<UserResponse> sortedUsersByName = api.sortUsersByName(api.controller().getUsers());
        assertThat(sortedUsersByName).isSortedAccordingTo(Comparator.comparing(user -> user.getName()));
    }

    @Test
    void deleteAllUsersTest(){
        usersData().forEach(user -> api.controller().createUser(user));
        api.deleteAllUsers();
    }

    @Test
    void verifyUsersListIsEmptyTest(){
        List<UserResponse> usersResponse = api.controller().getUsers();
        assertThat(usersResponse).isEmpty();
    }
}
