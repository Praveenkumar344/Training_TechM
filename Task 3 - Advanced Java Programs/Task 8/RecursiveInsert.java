import java.sql.*;

public class RecursiveInsert {
    static void insertData(Connection conn, String query, int count, int mark) throws SQLException {
        if (count == 0)
            return;

        PreparedStatement pstmt = conn.prepareStatement(query);

        pstmt.setInt(1, count);
        pstmt.setString(2, "Student" + count);
        pstmt.setInt(3, mark);
        pstmt.executeUpdate();

        insertData(conn, query, count - 1, mark + 10);
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root",
                "praveen123")) {
            String query = "INSERT INTO students (id, name, marks) VALUES (?, ?, ?)";
            insertData(conn, query, 5, 10);
            System.out.println("Inserted 5 records successfully!");
        } catch (Exception e) {
            System.out.println("error : " + e);
        }
    }
}
