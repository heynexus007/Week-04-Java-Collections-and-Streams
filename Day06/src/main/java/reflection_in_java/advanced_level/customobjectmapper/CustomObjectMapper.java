package reflection_in_java.advanced_level.customobjectmapper;

import java.util.*;
import java.lang.reflect.*;
class Person {
    private String name;
    private int age;
}
public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            if (properties.containsKey(field.getName())) {
                field.set(obj, properties.get(field.getName()));
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> data = Map.of("name", "Jack", "age", 30);
        Person person = toObject(Person.class, data);
    }
}
