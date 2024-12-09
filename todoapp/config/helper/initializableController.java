package todoapp.config.helper;

/**
 * Interface for initializing controllers with parameters.
 * This is typically used to pass data between different views or controllers.
 */
public interface InitializableController {
    /**
     * Method to initialize the controller with parameters.
     *
     * @param params Array of objects to pass initialization data.
     */
    void initData(Object[] params);
}
