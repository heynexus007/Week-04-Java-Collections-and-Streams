package custom_annotations.intermediate_level.maxlength_annotation;

import java.lang.annotation.*;
import static java.lang.System.*;

// Define MaxLength annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

// User class with validation
class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        if (username.length() > 10) {
            throw new IllegalArgumentException("Username exceeds max length of 10 characters");
        }
        this.username = username;
    }
}
public class MaxLengthAnnotation {
    public static void main(String[] args) {
        try {
            User user1 = new User("ShortName");
            out.println("User created successfully!");

            User user2 = new User("VeryLongUsername");
        } catch (IllegalArgumentException e) {
            out.println("###Error limit exceeded! ");
        }
    }
}
