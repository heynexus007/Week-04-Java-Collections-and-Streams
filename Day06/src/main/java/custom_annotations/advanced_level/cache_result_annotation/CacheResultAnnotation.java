package custom_annotations.advanced_level.cache_result_annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.*;
import static java.lang.System.*;

// Define @CacheResult annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

// Class with expensive method computations
class MathOperations {
    private static final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int square(int n) {
        if (cache.containsKey(n)) {
            out.println("Fetching from cache----");
            return cache.get(n);
        }
        int result = n * n;
        cache.put(n, result);
        return result;
    }
}
public class CacheResultAnnotation {
    public static void main(String[] args) throws Exception {
        MathOperations operations = new MathOperations();
        Method m = MathOperations.class.getMethod("square", int.class);

        out.println("First computation : " + m.invoke(operations, 5));
        out.println("Second computation : " + m.invoke(operations, 5));
    }
}
