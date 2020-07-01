package ua.spring.app.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Hashtable;

import static ua.spring.app.dao.ConstantQuery.CHECK_EXISTED_TABLES;

/**
 * Class represents process of connection to the database, creates tables and fills them,
 * after that close the connection.
 *
 * @Repositry - shows that the class functions as a repository
 * @PropertySource -  convenient mechanism for adding property sources to the environment
 */
@Repository
@PropertySource("classpath:application.properties")
public class ManageDb implements Connectable {

    /**
     * Constant for this class that add logging functionality.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ManageDb.class);

    /**
     * Part of JDBC get ability to obtain a connection to the database.
     */
    private DataSource dataSource;

    /**
     * The Initial JNDI Context.
     */
    private Context context;

    /**
     * Represents a link from an application to the database.
     */
    protected Connection connection;

    /**
     * An object that represents a database table entry.
     */
    protected ResultSet rs;
    /**
     * An SQL Statement that is precompiled
     */
    protected PreparedStatement ps;

    /**
     * Retrieve the url address from property file to Weblogic.
     */
    @Value("${URL_DB}")
    private String urlAddress;

    /**
     * Retrieve the JNDI name from property file to Weblogic.
     */
    @Value("${JNDI_NAME_DB}")
    private String nameDataBase;

    /**
     * Retrieve the class of context factory to Weblogic.
     */
    @Value("${CONTEXT_FACTORY}")
    private String contextFactory;

    /**
     * Inject the field of ResourceLoader object to retrieve resource files
     * classpath.
     */
    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * Integer number of quantity of tables in database.
     */
    private int numberTables;

    /**
     * {@inheritDoc}
     */
    @Override
    public void connectDB() {
        Hashtable<String, String> hashtable = new Hashtable<>();
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

    /**
     * Method that check if tables that starts with name 'LAB3PN' existed in the database,
     * if there's no - applications runs script for creation and filling these tables.
     *
     * @throws SQLException can't create object of PS or execute specific query
     * @PostConstruct involves into Spring Bean's lifecycle before creating object after calling
     * constructor
     */
    @PostConstruct
    public void runScript() throws SQLException {
        connectDB();
        ps = connection.prepareStatement(CHECK_EXISTED_TABLES);
        rs = ps.executeQuery();
        while (rs.next()) {
            numberTables = rs.getInt("QUANTITY");
        }
        if (numberTables == 0) {
            Resource resourceCreation = resourceLoader.getResource("classpath:creationScript.sql");
            Resource resourceFilling = resourceLoader.getResource("classpath:fillingScript.sql");
            ScriptUtils.executeSqlScript(connection, new EncodedResource(resourceCreation, StandardCharsets.UTF_8));
            ScriptUtils.executeSqlScript(connection, new EncodedResource(resourceFilling, StandardCharsets.UTF_8));
        }
        disconnectDB();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void disconnectDB() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null) {
                connection.close();
            }
            context.close();
        } catch (NamingException | SQLException e) {
            LOGGER.error("Can't disconnect from our DB", e);
        }
    }
}
