package reflection_in_java.intermediate_level.staticfield;

import java.lang.reflect.*;
import static java.lang.System.*;
class Configuration {
    private static String API_KEY = "OLD_KEY";
}
public class AccessAndModifyStaticField {
    public static void main(String[] args) throws Exception {
        Field field = Configuration.class.getDeclaredField("API_KEY");
        field.setAccessible(true);
        field.set(null, "NEW_KEY");

        out.println("Updated API_KEY: " + field.get(null));
    }
}
