package reflection_in_java.advanced_level.customloggingproxy;

import java.lang.reflect.*;
import static java.lang.System.*;
interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        out.println("Hello, World!");
    }
}

class LoggingProxy {
    public static <T> T createProxy(T obj) {
        return (T) Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                (proxy, method, args) -> {out.println("Calling method : " + method.getName());
                    return method.invoke(obj, args);
                }
        );
    }
}

public class CustomLoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = LoggingProxy.createProxy(new GreetingImpl());
        greeting.sayHello();
    }
}
