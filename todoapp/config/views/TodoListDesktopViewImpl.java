package todoapp.views;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;
import todoapp.Main;
import todoapp.helper.SceneHelper;

@Component("todoListDesktopView")
public class TodoListDesktopViewImpl extends Application implements TodoListView {

    public TodoListDesktopViewImpl() {
    }

    @Override
    public void run() {
        launch();
    }

    @Override
    public void start(final Stage stage) throws Exception {
        // Set the primary stage for the application
        SceneHelper.setPrimaryStage(stage);

        // Get the LoginController from the Spring context and switch to the login view
        LoginController loginController = Main.applicationContext.getBean(LoginController.class);
        SceneHelper.switchScene("todoapp/pages/login/login-view.fxml", loginController);
    }
}
