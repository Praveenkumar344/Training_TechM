
import java.sql.*;
import java.util.Scanner;

public class test {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        boolean run = true;

        String url = "jdbc:mysql://localhost:3306/companies";
        String userName = "root";
        String password = "praveen123";
        Connection connection = DriverManager.getConnection(url, userName, password);
        Statement statement = connection.createStatement();
        while (run) {
            System.out.println(
                    "1. View all details  \n2. Insert details\n3. Update detail by employee id\n4. Delete empolyee details\n5. Exit");
            System.out.print("Enter the operation number : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ViewRecords(statement);
                    break;
                case 2:
                    insertValues(statement);
                    break;
                case 3:
                    updateRecord(connection);
                    break;
                case 4:
                    deleteRecord(connection);
                    break;
                case 5:
                    run = false;
                    break;
                default:
                    System.out.println("\nEnter the correct choice\n");
                    break;

            }
        }
    }

    static void deleteRecord(Connection connection) throws SQLException {
        System.out.print("Enter the employee Id :");
        int empId = sc.nextInt();
        String query = "select Exists(select 1 from company where empId=?);";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, empId);

        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) == 0) {
            System.out.println("\nId not found try again with valid employee Id\n");
            return;
        }
        pst.close();
        query = "DELETE FROM company WHERE empId=?";
        pst = connection.prepareStatement(query);
        pst.setInt(1, empId);
        System.out.println("\n" + pst.executeUpdate() + " row deleted\n");

    }

    static void updateRecord(Connection connection) throws SQLException {
        System.out.print("Enter the employee Id :");
        int empId = sc.nextInt();
        String query = "select Exists(select 1 from company where empId=?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setInt(1, empId);

        ResultSet rs = pst.executeQuery();
        if (rs.next() && rs.getInt(1) == 0) {
            System.out.println("\nId not found try again with valid employee Id\n");
            return;
        }
        System.out.print("Enter Employee Name : ");
        String empName = sc.next();
        System.out.print("Enter Employee Phone : ");
        long empPhone = sc.nextLong();
        System.out.print("Enter Employee Email : ");
        String empEmail = sc.next();

        query = "update company set empName=?, empPhoneNo=?, empEmail=? where empId=?;";
        pst = connection.prepareStatement(query);
        pst.setString(1, empName);
        pst.setLong(2, empPhone);
        pst.setString(3, empEmail);
        pst.setInt(4, empId);

        System.out.println("\n" + pst.executeUpdate() + " row updated successfully \n");

    }

    static void ViewRecords(Statement statement) throws SQLException {
        String query = "select * from company";
        ResultSet rs = statement.executeQuery(query);
        System.out.println("Employee Details : ");
        System.out.println("ID       |NAME     |PHONENO.        |EMAIL          ");
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + "        " + rs.getString(2) + "      " + rs.getLong(3) + "     "
                            + rs.getString(4));
        }
        System.out.println();

    }

    static void insertValues(Statement statement) throws SQLException {
        System.out.print("Enter Employee Id : ");
        int empId = sc.nextInt();
        System.out.print("Enter Employee Name : ");
        String empName = sc.next();
        System.out.print("Enter Employee Phone : ");
        long empPhone = sc.nextLong();
        System.out.print("Enter Employee Email : ");
        String empEmail = sc.next();
        String query = "select Exists(select 1 from company where empId=" + empId + ");";

        ResultSet rs = statement.executeQuery(query);
        if (rs.next() && rs.getInt(1) == 1) {
            System.out.println("\nemployee Id " + empId + " is already used try inserting  again with vaid ID.\n");
            return;
        }

        query = "insert into company values(" + empId + ",'" + empName + "'," + empPhone + ",'" + empEmail
                + "')";
        statement.executeUpdate(query);
        System.out.println("\n 1 row inserted successfully\n");
    }
}
