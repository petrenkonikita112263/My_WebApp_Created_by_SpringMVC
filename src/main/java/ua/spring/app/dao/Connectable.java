package ua.spring.app.dao;

import javax.sql.DataSource;

public interface Connectable {

    void connectDB();

    void disconnectDB();

}
