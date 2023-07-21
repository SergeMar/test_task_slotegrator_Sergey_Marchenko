package body;

import lombok.Data;
import response.UserResponse;

@Data
public class UserBody {
    private String currency_code;
    private String email;
    private String name;
    private String password_change;
    private String password_repeat;
    private String surname;
    private String username;

    public UserBody(String email) {
        this.email = email;
    }

    public UserBody(String code, String email, String name, String password, String surname, String username) {
        this.currency_code = code;
        this.email = email;
        this.name = name;
        this.password_change = password;
        this.password_repeat = password;
        this.surname = surname;
        this.username = username;
    }

    public UserResponse toResponse(){
        return new UserResponse(
                this.email,
                this.name,
                this.surname,
                this.username
        );
    }
}
