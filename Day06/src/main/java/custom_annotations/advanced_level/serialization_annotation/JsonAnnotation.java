package custom_annotations.advanced_level.serialization_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.*;
import static java.lang.System.*;

// Define 'JsonField' annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

// User class with 'JsonField' annotation
class User {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
public class JsonAnnotation {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User("Drake", 25);
        out.println(toJson(user));
    }

    public static String toJson(Object obj) throws IllegalAccessException {
        Map<String, String> jsonMap = new HashMap<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);

            if (f.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = f.getAnnotation(JsonField.class);
                jsonMap.put(annotation.name(), f.get(obj).toString());
            }
        }
        return jsonMap.toString();
    }
}
