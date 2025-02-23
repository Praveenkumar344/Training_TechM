import java.sql.*;
import java.util.Scanner;

public class DeleteRow {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "praveen123");
                Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter ID to delete: ");
            int id = sc.nextInt();

            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Deleted successfully");
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
    }
}
