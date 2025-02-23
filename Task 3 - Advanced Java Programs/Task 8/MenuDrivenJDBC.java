import java.sql.*;
import java.util.Scanner;

public class MenuDrivenJDBC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "praveen123");
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Insert a new Row");
                System.out.println("2. Update a Row");
                System.out.println("3. Delete a Row");
                System.out.println("4. Select a Row");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        System.out.print("Enter Name: ");
                        String name = sc.next();
                        System.out.print("Enter Marks: ");
                        int marks = sc.nextInt();

                        PreparedStatement insertStmt = conn
                                .prepareStatement("INSERT INTO students (id, name, marks) VALUES (?, ?, ?)");
                        insertStmt.setInt(1, id);
                        insertStmt.setString(2, name);
                        insertStmt.setInt(3, marks);
                        insertStmt.executeUpdate();
                        System.out.println("Row inserted!");
                        break;

                    case 2:
                        System.out.print("Enter ID to update: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new Name: ");
                        String updateName = sc.next();
                        System.out.print("Enter new Marks: ");
                        int updateMarks = sc.nextInt();

                        PreparedStatement updateStmt = conn
                                .prepareStatement("UPDATE students SET name = ?, marks = ? WHERE id = ?");
                        updateStmt.setString(1, updateName);
                        updateStmt.setInt(2, updateMarks);
                        updateStmt.setInt(3, updateId);
                        int updated = updateStmt.executeUpdate();
                        System.out.println(updated > 0 ? "Update successful!" : "ID not found.");
                        break;

                    case 3:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();

                        PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM students WHERE id = ?");
                        deleteStmt.setInt(1, deleteId);
                        int deleted = deleteStmt.executeUpdate();
                        System.out.println(deleted > 0 ? "Row deleted!" : "ID not found.");
                        break;

                    case 4:
                        System.out.print("Enter ID to select: ");
                        int selectId = sc.nextInt();

                        PreparedStatement selectStmt = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
                        selectStmt.setInt(1, selectId);
                        ResultSet rs = selectStmt.executeQuery();

                        if (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name")
                                    + ", Marks: " + rs.getInt("marks"));
                        } else {
                            System.out.println("ID not found.");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice, try again.");
                }
            }
        } catch (SQLException e) {
            System.out.println("error : " + e);
        }
    }
}
