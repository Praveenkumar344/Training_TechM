import java.sql.*;
import java.util.Scanner;

public class UpdateRow {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "praveen123");
                Scanner sc = new Scanner(System.in)) {

            System.out.println("Enter ID to update: ");
            int id = sc.nextInt();
            System.out.println("Enter new name: ");
            String name = sc.next();
            System.out.println("Enter new marks: ");
            int marks = sc.nextInt();

            String query = "UPDATE students SET name = ?, marks = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, marks);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("Update successful!");
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
    }
}
