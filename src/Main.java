import edu.aitu.oop3.db.DatabaseConnection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
public class Main {
    void main(){
        try (Connection connection = DatabaseConnection.getConnection()){
            System.out.println("Connection successful!");

            String sql = "SELECT CURRENT_TIMESTAMP";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                     ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                        System.out.println("Database time:" + rs.getTimestamp(1));
                }
            }
            }catch (SQLException e){
                System.out.println("Error while connecting to database:");
                e.printStackTrace();
        }
    }
}