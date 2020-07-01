package ua.spring.app.dao;

/**
 * Final class that holds all list of queries for Oracle.
 */
public final class ConstantQuery {

    /**
     * Private EVC.
     */
    private ConstantQuery() {
    }

    public static final String CHECK_EXISTED_TABLES = "SELECT COUNT(*) QUANTITY "
            + "FROM all_tables WHERE TABLE_NAME LIKE 'LAB3PN%'";
    public static final String ADD_FLIGHT_TICKET = "INSERT INTO LAB3PN_TICKET(TICKET_ID, "
            + "SERIAL_NUMBER, FLIGHT_ID, "
            + "DESCRIPTION, FLIGHT_DATE, ARRIVAL_DATE, PRICE) "
            + "VALUES(LAB3PN_TICKET_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";
    public static final String UPDATE_FLIGHT_TICKET = "UPDATE LAB3PN_TICKET "
            + "SET SERIAL_NUMBER = ?, FLIGHT_ID = ?, DESCRIPTION = ?, FLIGHT_DATE = ?, "
            + "ARRIVAL_DATE = ?, PRICE = ? WHERE TICKET_ID = ?";
    public static final String DELETE_FLIGHT_TICKET = "DELETE LAB3PN_TICKET WHERE TICKET_ID = ?";
    public static final String PERFORM_ORDER = "BEGIN "
            + "INSERT INTO LAB3PN_CUSTOMER_ORDER(CUSTOMER_ORDER_ID, CUSTOMER_ID, "
            + "ORDER_TIME, PRICE, DISCOUNT, FINAL_PRICE) VALUES (LAB3PN_CUSTOMER_SEQ.NEXTVAL, "
            + "(SELECT CUSTOMER_ID FROM LAB3PN_USERS WHERE LAB3PN_USERS.USERNAME = ?), "
            + "?, ?, ?, ?); INSERT INTO LAB3PN_ORDER_TICKET(ORDER_ID, CUSTOMER_ORDER_ID, TICKET_ID) "
            + "VALUES (LAB3PN_ORDER_SEQ.NEXTVAL, LAB3PN_CUSTOMER_SEQ.currval, ?); "
            + "END;";

    public static final String ADD_CUSTOMER = "INSERT "
            + "INTO LAB3PN_USERS(CUSTOMER_ID, USERNAME, PASSWORD, AUTHORITY, ENABLED)\n"
            + "VALUES(LAB3PN_USERS_SEQ.NEXTVAL, ?, ?, 'ROLE_CUSTOMER', 1)";
    public static final String FIND_CUSTOMER = "SELECT * FROM LAB3PN_USERS "
            + "WHERE CUSTOMER_ID = ? AND AUTHORITY LIKE 'ROLE_CUSTOMER'";
    public static final String CUSTOMERS_LIST = "SELECT * FROM LAB3PN_USERS "
            + "WHERE AUTHORITY LIKE 'ROLE_CUSTOMER'";
    public static final String UPDATE_CUSTOMER = "UPDATE LAB3PN_USERS "
            + "SET USERNAME = ?, PASSWORD = ? WHERE CUSTOMER_ID = ?";
    public static final String DELETE_CUSTOMER = "DELETE LAB3PN_USERS "
            + "WHERE CUSTOMER_ID = ? AND AUTHORITY LIKE 'ROLE_CUSTOMER'";

    public static final String FIND_TICKET = "SELECT * FROM LAB3PN_TICKET WHERE TICKET_ID = ?";
    public static final String VIEW_TICKET_HISTORY = "SELECT * FROM LAB3PN_ORDER_TICKET "
            + "WHERE CUSTOMER_ORDER_ID = "
            + "(SELECT CUSTOMER_ORDER_ID FROM LAB3PN_CUSTOMER_ORDER WHERE CUSTOMER_ID = "
            + "(SELECT CUSTOMER_ID FROM LAB3PN_USERS WHERE USERNAME LIKE ?) AND ROWNUM = 1)";
    public static final String VIEW_ORDER_HISTORY = "SELECT * FROM LAB3PN_CUSTOMER_ORDER "
            + "WHERE CUSTOMER_ID = "
            + "(SELECT CUSTOMER_ID FROM LAB3PN_USERS WHERE USERNAME = ?)";

    public static final String VIEW_TICKET_LIST = "SELECT * FROM LAB3PN_TICKET";
    public static final String VIEW_AIRPORT_LIST = "SELECT * FROM LAB3PN_AIRPORT";
    public static final String VIEW_FLIGHT_LIST = "SELECT * FROM LAB3PN_FLIGHT";
    public static final String VIEW_PLANE_LIST = "SELECT * FROM LAB3PN_PLANE";

}
