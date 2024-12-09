package todoapp;

import javafx.application.Application;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import todoapp.views.TodoListView;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    // Hold the application context for later use
    public static ConfigurableApplicationContext applicationContext;

    public static void main(String[] args) {
        // Initialize Spring context
        applicationContext = new AnnotationConfigApplicationContext(Main.class);

        // Run the JavaFX application
        Application.launch(TodoListView.class, args);
    }
}
