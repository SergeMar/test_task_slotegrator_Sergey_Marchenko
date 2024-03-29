import body.LoginBody;
import body.UserBody;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import response.LoginResponse;
import response.UserResponse;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

public class ApiController {
    private final String LOGIN_PATH = "api/tester/login";
    private final String CREATE_PATH = "api/automationTask/create";
    private final String ALL_USERS_PATH = "api/automationTask/getAll";
    private final String DELETE_USER_PATH = "api/automationTask/deleteOne";
    private final String ONE_USER_PATH = "api/automationTask/getOne";
    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer ";

    protected RequestSpecification request(String path){
        return given()
                .baseUri(ApiParams.apiUrl)
                .basePath(path)
                .contentType(JSON);
    }

    public LoginResponse login() {
        Response response = request(LOGIN_PATH)
                .body(new LoginBody(ApiParams.email, ApiParams.password))
                .when()
                .post();

        return response.then()
                .extract().as(LoginResponse.class);
    }

    public List<UserResponse> getUsers() {
        Response response = request(ALL_USERS_PATH)
                .header(new Header(AUTHORIZATION, String.format("%s%s", BEARER, Token.getInstance())))
                .when()
                .get();

        return response.then().statusCode(HttpStatus.SC_OK)
                .extract().as(new TypeRef<>() {});
    }

    public void deleteUser(String id) {
        String path = String.format("%s/%s", DELETE_USER_PATH, id);
        Response response = request(path)
                .header(new Header(AUTHORIZATION, String.format("%s%s", BEARER, Token.getInstance())))
                .when()
                .delete();

        response.then().statusCode(HttpStatus.SC_OK);
    }

    public UserResponse getUser(String email) {
        Response response = request(ONE_USER_PATH)
                .header(new Header(AUTHORIZATION, String.format("%s%s", BEARER, Token.getInstance())))
                .body(new UserBody(email))
                .when()
                .post();

        return response.then().statusCode(HttpStatus.SC_CREATED)
                .extract().as(UserResponse.class);
    }

    public UserResponse createUser(UserBody user) {
        Response response = request(CREATE_PATH)
                .header(new Header(AUTHORIZATION, String.format("%s%s", BEARER, Token.getInstance())))
                .body(user)
                .when()
                .post();

        return response.then().statusCode(HttpStatus.SC_CREATED)
                .extract().as(UserResponse.class);
    }
}
