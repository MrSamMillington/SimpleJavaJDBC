import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class JdbcTest {

    private Connection myConn = null;

    @Before
    public void setUp() throws Exception {
        //1. Get connection to DB
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "student", "password123!");
    }

    @Test
    public void testConnection() throws SQLException {

        Statement myStmt = null;
        ResultSet myRs = null;


            System.out.println("Successful Connection!");

            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery("SELECT * FROM actor LIMIT 5");

            while (myRs.next()) {
                System.out.println(myRs.getString("first_name"));
            }


    }

    @Test
    public void insertData() throws SQLException {

        //2. create a statement
        Statement myStmt = myConn.createStatement();

        int rowsAffected = myStmt.executeUpdate(
                "insert into actor " +
                        "(first_name, last_name) " +
                        "values " +
                        "('NICK', 'CAGE')"
        );

        ResultSet myRs = myStmt.executeQuery("SELECT * FROM actor  WHERE first_name = 'NICK'" );

        while (myRs.next()) {
            System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
        }


    }

    @Test
    public void updateData() throws SQLException {

        Statement myStmt = myConn.createStatement();

        int rowsAffected = myStmt.executeUpdate(
                "update actor " +
                        "set last_name='STALLONE' " +
                        "where " +
                        "first_name='NICK' and last_name='CAGE'"
        );

        ResultSet myRs = myStmt.executeQuery("SELECT * FROM actor  WHERE first_name = 'NICK'" );

        while (myRs.next()) {
            System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
        }

    }

    @Test
    public void deleteData() throws SQLException {

        //wont work because of foreign key contraints in mysql sakila db - but this is how it's done usually:
//        Statement myStmt = myConn.createStatement();
//
//        int rowsAffected = myStmt.executeUpdate(
//                "delete from actor " +
//                        "where " +
//                        "first_name='NICK'"
//        );
//
//        ResultSet myRs = myStmt.executeQuery("SELECT * FROM actor  WHERE first_name = 'NICK'" );
//
//        while (myRs.next()) {
//            System.out.println(myRs.getString("first_name") + " " + myRs.getString("last_name"));
//        }


    }
}
