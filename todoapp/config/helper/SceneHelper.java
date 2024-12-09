package todoapp.helper;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for managing and switching JavaFX scenes.
 */
public class SceneHelper {
    private static final Logger log = LoggerFactory.getLogger(SceneHelper.class.getName());
    private static Stage primaryStage;

    /**
     * Sets the primary stage for the application.
     *
     * @param stage The main stage of the application.
     */
    public static void setPrimaryStage(Stage stage) {
        SceneHelper.primaryStage = stage;
    }

    /**
     * Switches to a new scene without parameters.
     *
     * @param fxmlFile       The FXML file to load.
     * @param controllerClass The controller class to use.
     */
    public static void switchScene(String fxmlFile, Object controllerClass) {
        switchScene(fxmlFile, controllerClass, null);
    }

    /**
     * Switches to a new scene with parameters.
     *
     * @param fxmlFile       The FXML file to load.
     * @param controllerClass The controller class to use.
     * @param params         Parameters to pass to the controller.
     */
    public static void switchScene(String fxmlFile, Object controllerClass, Object[] params) {
        FXMLLoader loader = new FXMLLoader(SceneHelper.class.getClassLoader().getResource(fxmlFile));
        if (controllerClass != null) {
            loader.setController(controllerClass);
        }

        try {
            Parent root = loader.load();

            // Pass parameters to the controller if applicable
            if (params != null && params.length > 0) {
                Object controller = loader.getController();
                if (controller instanceof InitializableController) {
                    ((InitializableController) controller).initData(params);
                }
            }

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception error) {
            log.error("Failed to switch scene: {}", error.getMessage(), error);
        }
    }
}
