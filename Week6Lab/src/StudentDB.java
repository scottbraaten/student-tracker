/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Scott Braaten
 */

/********************************************************** 
Program Name: StudentDB.java
Programmer's Name: Scott Braaten
Program Description: This class creates a connection with the local
* MySQL database and handles operations with this database, including
* inserting data entries and retrieving all data entries.
***********************************************************/

public class StudentDB {

    // database information
    private final String DATABASE_NAME = "students";
    private final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
    private final String USER_NAME = "student";
    private final String PASSWORD = "student";

    // default constructor
    public StudentDB() {}
    
    // retrieves all entries from student table in students database
    public ArrayList<Student> getAll() throws ClassNotFoundException, SQLException {
        // create AL
        ArrayList<Student> list = new ArrayList<Student>();

        // connect to db
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);

        // prepares statement
        Statement statement = conn.createStatement();
        String SQL = "SELECT * FROM student";
        ResultSet rs = statement.executeQuery(SQL);

        // iterate through results of query and instantiate new Student object
        while (rs.next()) {
            // create Student
            Student student = new Student();
            student.setScores(new int[3]);
            student.setName(rs.getString(2));
            student.pushScores(0, rs.getInt(3));
            student.pushScores(1, rs.getInt(4));
            student.pushScores(2, rs.getInt(5));
            
            // add student to list
            list.add(student);
        }
        // close conn
        conn.close();

        return list;
    }

    // insets student data into database as single entry
    public void add(Student student) throws ClassNotFoundException, SQLException {
        // check for driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // connect to db
        Connection conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);

        // add record
        String strSQL = "INSERT INTO student (name, first_score, "
                + "second_score, third_score)"
                + "VALUES(?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(strSQL);
        pstmt.setString(1, student.getName());
        pstmt.setInt(2, student.getScores()[0]);
        pstmt.setInt(3, student.getScores()[1]);
        pstmt.setInt(4, student.getScores()[2]);

        // execute preparedstatement
        pstmt.execute();

        // close connection
        conn.close();
    }
}
