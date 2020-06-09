package ua.spring.app.dao;

import oracle.jdbc.driver.OracleDriver;
import org.apache.log4j.Logger;
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
import java.sql.*;
import java.util.Hashtable;

@Repository
@PropertySource("classpath:application.properties")
public class ManageDb implements Connectable {

    private static final Logger LOGGER = Logger.getLogger(ManageDb.class);
    private DataSource dataSource;
    private Context context;
    protected Connection connection;
    protected ResultSet rs;
    protected PreparedStatement ps;
    private Hashtable<String, String> hashtable = new Hashtable<>();

    @Value("${URL_DB}")
    private String urlAddress;

    @Value("${JNDI_NAME_DB}")
    private String nameDataBase;

    @Value("${CONTEXT_FACTORY}")
    private String contextFactory;

    private Driver driver;

//    @Override
//    public void connectDB() {
//        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, contextFactory);
//        hashtable.put(Context.PROVIDER_URL, urlAddress);
//        try {
//            context = new InitialContext(hashtable);
//            dataSource = (DataSource) context.lookup(nameDataBase);
//            connection = dataSource.getConnection();
//            LOGGER.info("Connection successfully got");
//        } catch (NamingException e) {
//            LOGGER.error("Wrong url or name, can't find this server", e);
//        } catch (SQLException e) {
//            LOGGER.error("Can't access to our DB", e);
//        }
//    }

    @Override
    public void connectDB() {
        driver = new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "FIRST_OWN_DB", "ujhskf[][fnf");
            if (!connection.isClosed()) {
                LOGGER.info("Connection is successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    private ResourceLoader resourceLoader;

    private int numberTables;

    @PostConstruct
    public void runScript() throws SQLException {
        connectDB();
        ps = connection.prepareStatement("SELECT COUNT(*) QUANTITY FROM all_tables WHERE owner='FIRST_OWN_DB' and TABLE_NAME like 'LAB3PN%'");
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

    @Override
    public void disconnectDB() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            connection.close();
//            if (connection != null) {
//                connection.close();
//            }
//            if (context != null) {
//                context.close();
//            }
//            context.close();
        } catch (SQLException e) {
            LOGGER.error("Can't disconnect from our DB", e);
        }
    }
}
