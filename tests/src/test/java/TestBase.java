import org.junit.jupiter.api.AfterEach;

public class TestBase {

    protected ApiBot api = new ApiBot();

    @AfterEach
    public void deleteUsers(){
        api.deleteAllUsers();
    }
}
