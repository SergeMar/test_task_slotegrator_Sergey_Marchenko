package data;

import body.UserBody;

import java.util.ArrayList;
import java.util.List;

public class DataUser {

    public static List<UserBody> usersRequest(){
        List<UserBody> users =new ArrayList<>();
        users.add(new UserBody("code", "email1@test.com", "Ivan", "password1", "Ivanov", "user1"));
        users.add(new UserBody("code", "email2@test.com", "Oleg", "password2", "Petrov", "user2"));
        users.add(new UserBody("code", "email3@test.com", "Mariya", "password3", "Sokolova", "user3"));
        users.add(new UserBody("code", "email4@test.com", "Svetlana", "password4", "Novikova", "user4"));
        users.add(new UserBody("code", "email5@test.com", "Petr", "password5", "Morozov", "user5"));
        users.add(new UserBody("code", "email6@test.com", "Sergey", "password6", "Lebedev", "user6"));
        users.add(new UserBody("code", "email7@test.com", "Olga", "password7", "Pavlova", "user7"));
        users.add(new UserBody("code", "email8@test.com", "Elena", "password8", "Andreeva", "user8"));
        users.add(new UserBody("code", "email9@test.com", "Nikolay", "password9", "Borisov", "user9"));
        users.add(new UserBody("code", "email10@test.com", "Natalya", "password10", "Frolova", "user10"));
        users.add(new UserBody("code", "email11@test.com", "Pavel", "password11", "Gusev", "user11"));
        users.add(new UserBody("code", "email12@test.com", "Vera", "password12", "Sorokina", "user12"));
        return users;
    }
}
