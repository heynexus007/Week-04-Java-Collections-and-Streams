package reflection_in_java.intermediate_level.retrieveannotations;

import java.lang.annotation.*;

import static java.lang.System.*;
// Define annotation
@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

// Apply annotation
@Author(name = "John Doe")
class Book {}
public class RetrieveAnnotationsAtRuntime {
    public static void main(String[] args) {
        Class<Book> clazz = Book.class;
        Author author = clazz.getAnnotation(Author.class);

        if (author != null) {
            out.println("Author: " + author.name());
        }
    }
}
