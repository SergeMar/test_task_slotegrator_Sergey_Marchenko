package response;


import lombok.Data;

import java.util.Objects;

@Data
public class UserResponse {
    private String id;
    private String email;
    private String name;
    private String surname;
    private String username;

    public UserResponse(String email, String name, String surname, String username) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserResponse userResponse = (UserResponse) o;
        return Objects.equals(email, userResponse.email) && Objects.equals(name, userResponse.name) && Objects.equals(surname, userResponse.surname) && Objects.equals(username, userResponse.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, surname, username);
    }
}
