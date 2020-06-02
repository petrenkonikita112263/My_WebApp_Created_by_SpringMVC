package ua.spring.app.dao;

import oracle.jdbc.driver.OracleDriver;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Hashtable;

@Component
@PropertySource("classpath:application.properties")
public class ManageDb implements Connectable {

    private static final Logger LOGGER = Logger.getLogger(ManageDb.class);
    private DataSource dataSource;
    private Context context;
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;
    private Hashtable<String, String> hashtable = new Hashtable<>();


    private String urlAddress;


    private String nameDataBase;


    private String contextFactory;

    public void setUrlAddress(@Value("${URL_DB}")String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public void setNameDataBase(@Value("${JNDI_NAME_DB}")String nameDataBase) {
        this.nameDataBase = nameDataBase;
    }

    public void setContextFactory(@Value("${CONTEXT_FACTORY}")String contextFactory) {
        this.contextFactory = contextFactory;
    }

    private Driver driver;

    @Override
    public void connectDB() {
        driver = new OracleDriver();
        try {
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",
                    "FIRST_OWN_DB", "ujhskf[][fnf");
            if (!connection.isClosed()) {
                System.out.println("Connection is successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        LOGGER.info("Set parameters for connection");
//        hashtable.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
//        hashtable.put(Context.PROVIDER_URL, "t3://localhost:7001");
//        try {
//            context = new InitialContext(hashtable);
//            dataSource = (DataSource) context.lookup("Test_1_Weblogic");
//            connection = dataSource.getConnection();
//            LOGGER.info("Connection successfully got");
//        } catch (NamingException e) {
//            LOGGER.error("Wrong url or name, can't find this server", e);
//        } catch (SQLException e) {
//            LOGGER.error("Can't access to our DB", e);
//        }
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
            Resource resource = resourceLoader.getResource("classpath:app_script.sql");
            ScriptUtils.executeSqlScript(connection, new EncodedResource(resource, StandardCharsets.UTF_8));
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
            if (connection != null) {
                connection.close();
            }
            if (context != null) {
                context.close();
            }
        } catch (NamingException e) {
            LOGGER.error("Wrong url or name, can't find this server", e);
        } catch (SQLException e) {
            LOGGER.error("Can't disconnect from our DB", e);
        }
    }
}
