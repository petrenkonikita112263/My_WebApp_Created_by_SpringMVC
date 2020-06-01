package ua.spring.app.dao;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

@PropertySource("classpath:application.properties")
public class ManageDb implements Connectable {

    private static final Logger LOGGER = Logger.getLogger(ManageDb.class);
    private DataSource dataSource;
    private Context context;
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    @Value("${URL_DB}")
    private String urlAddress;

    @Value("${JNDI_NAME_DB}")
    private String nameDataBase;

    @Value("${CONTEXT_FACTORY}")
    private String contextFactory;

    @Override
    public void connectDB() {
        Hashtable hashtable = new Hashtable();
        LOGGER.info("Set parameters for connection");
        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, contextFactory);
        hashtable.put(Context.PROVIDER_URL, urlAddress);
        try {
            context = new InitialContext(hashtable);
            dataSource = (DataSource) context.lookup(nameDataBase);
            connection = dataSource.getConnection();
            LOGGER.info("Connection successfully got");
        } catch (NamingException e) {
            LOGGER.error("Wrong url or name, can't find this server", e);
        } catch (SQLException e) {
            LOGGER.error("Can't access to our DB", e);
        }
    }

    @PostConstruct
    public void runScript() {
        connectDB();
        try {
//            File dropDataBase = ResourceUtils.getFile("classpath:app_drop_script.sql");
            File createDataBase = ResourceUtils.getFile("classpath:app_script.sql");
            LOGGER.info("All the scripts were found");
            ScriptRunner scriptRunner = new ScriptRunner(connection);
            scriptRunner.setStopOnError(false);
//            scriptRunner.runScript(new BufferedReader(new FileReader(dropDataBase)));
            scriptRunner.runScript(new BufferedReader(new FileReader(createDataBase)));
        } catch (FileNotFoundException e) {
            LOGGER.error("Script file wasn't found in the folder");
        } finally {
            disconnectDB();
        }
    }

    @Override
    public void disconnectDB() {
        try {
            rs.close();
            ps.close();
            connection.close();
            context.close();
        } catch (NamingException e) {
            LOGGER.error("Wrong url or name, can't find this server", e);
        } catch (SQLException e) {
            LOGGER.error("Can't disconnect from our DB", e);
        }
    }
}
