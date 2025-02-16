package custom_annotations.advanced_level.role_allowed_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import static java.lang.System.*;

// Define @RoleAllowed annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

// Class with restricted access methods
class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        out.println("Admin task executed!!!");
    }

    @RoleAllowed("USER")
    public void userTask() {
        out.println("User task executed!!!");
    }
}
public class RoleAllowedAnnotation {
    public static void main(String[] args) throws Exception {
        SecureService service = new SecureService();
        // Simulated user role
        String currentUserRole = "USER";

        for (Method m : SecureService.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed role = m.getAnnotation(RoleAllowed.class);
                if (role.value().equals(currentUserRole)) {
                    m.invoke(service);
                }
                else {
                    out.println("Access Denied! " + m.getName());
                }
            }
        }
    }
}
