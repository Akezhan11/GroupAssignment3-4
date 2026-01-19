package edu.aitu.oop3.db;
import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DatabaseMember {
    void main(){
        System.out.println("Demo:create table,insert,select");
        try(Connection connection = DatabaseConnection.getConnection()){
            createTableIfNeeded(connection);
            insertUser(connection,"Alice","alice@example.com");
            printAllUsers(connection);
        }catch(SQLException E){
            System.out.println("Database Error");
            E.printStackTrace();
        }
    }
    private static void createTableIfNeeded(Connection connection) throws SQLException {
        String sql = """
                create table if not exists members(
                id serial primary key,
                name varchar(255) not null,
                email varchar(255) unique not null
                );
                """;
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.execute();
            System.out.println("Table created");
        }
    }
    private static void insertUser(Connection connection, String name, String email) throws SQLException {
        String sql = "insert into members(name,email) values(?,?)";
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setString(1,name);
            stmt.setString(2,email);
            int rows = stmt.executeUpdate();
            System.out.println(rows+" row inserted");
        }
    }
    private static void printAllUsers(Connection connection) throws SQLException {
        String sql = "select * from members";
        try(PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()){
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.printf(" %d | %s | %s%n", id, name, email);;
            }
        }
    }
}
