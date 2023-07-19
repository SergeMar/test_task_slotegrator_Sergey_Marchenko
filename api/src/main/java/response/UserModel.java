package response;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserModel {
    private String id;
    private String email;
    private String name;
    private String surname;
    private String username;
}
