import org.junit.jupiter.api.AfterEach;

public class TestBase {

    public ApiBot api = new ApiBot();

    @AfterEach
    public void deleteUsers(){
        api.deleteAllUsers();
    }
}
