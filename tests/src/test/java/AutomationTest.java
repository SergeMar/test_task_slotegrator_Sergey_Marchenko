import body.UserBody;
import org.junit.jupiter.api.Test;
import response.UserModel;

import java.util.Comparator;
import java.util.List;

import static data.DataUser.usersRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class AutomationTest extends TestBase {

    @Test
    void getAccessTokenTest() {
        String userToken = api.controller().getToken();
        assertThat(userToken).isNotNull();
    }

    @Test
    void registerPlayersTest() {
        api.createUsers(usersRequest());
        List<UserModel> usersResponse = api.getAllUsers();
        assertThat(usersResponse.size()).isEqualTo(12);
    }

    @Test
    void getAndVerifyUserTest() {
        UserBody userRequest = usersRequest().get(0);
        api.createUser(userRequest);
        UserModel userResponse = api.getUser(userRequest.getEmail());
        assertThat(userResponse.getName()).isEqualTo(userRequest.getName());
        assertThat(userResponse.getEmail()).isEqualTo(userRequest.getEmail());
        assertThat(userResponse.getSurname()).isEqualTo(userRequest.getSurname());
        assertThat(userResponse.getUsername()).isEqualTo(userRequest.getUsername());
    }

    @Test
    void getAndSortPlayersTest(){
        api.createUsers(usersRequest());
        List<UserModel> sortedUsersByName = api.sortUsersByName(api.getAllUsers());
        assertThat(sortedUsersByName).isSortedAccordingTo(Comparator.comparing(UserModel::getName));
    }

    @Test
    void deleteAllUsersTest(){
        api.createUsers(usersRequest());
        api.deleteAllUsers();
    }

    @Test
    void verifyUsersListAfterDeletingTest(){
        api.createUsers(usersRequest());
        api.deleteAllUsers();
        List<UserModel> usersResponse = api.getAllUsers();
        assertThat(usersResponse).isEmpty();
    }
}
