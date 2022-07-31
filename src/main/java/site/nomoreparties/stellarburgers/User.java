package site.nomoreparties.stellarburgers;

import com.github.javafaker.Faker;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    static Faker faker = new Faker();

    private String email;
    private String password;
    private String name;

    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public static User getRandomUser() {
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(8, 9);
        String name = faker.name().firstName();
        return new User(email, password, name);
    }

    public static User getRandomUser(int a, int b) {
        String email = faker.internet().safeEmailAddress();
        String password = faker.internet().password(a, b);
        String name = faker.name().firstName();
        return new User(email, password, name);
    }
}