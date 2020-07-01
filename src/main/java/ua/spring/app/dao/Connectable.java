package ua.spring.app.dao;

/**
 * Interface class that holds main methods of connect|disconnect operations
 * with database.
 */
public interface Connectable {

    /**
     * Method that perform connection to our database.
     */
    void connectDB();

    /**
     * Method that close connection to our database.
     */
    void disconnectDB();

}
