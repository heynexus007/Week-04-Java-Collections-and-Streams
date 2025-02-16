package reflection_in_java.advanced_level.dependencyinjection;

import java.lang.reflect.*;
import java.lang.annotation.*;
import static java.lang.System.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    void execute() {
        out.println("Service executed!!!");
    }
}

class Consumer {
    @Inject
    private Service service;

    void useService() { service.execute(); }
}
class IDContainer {
    public static void injectDependencies(Object obj) throws Exception {
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {
                f.setAccessible(true);
                f.set(obj, f.getType().getDeclaredConstructor().newInstance());
            }
        }
    }
}
public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        Consumer consumer = new Consumer();
        IDContainer.injectDependencies(consumer);
        consumer.useService();
    }
}
