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
            printAllUsers(connection)
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
}
