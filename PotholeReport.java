import java.sql.*;
import java.util.Scanner;

public class PotholeReport {
    private static int lastReportID;
    private int reportID;
    private String phStreetLocation;
    private String phAddress;
    private int phSize;
    private String phRepairType;

    // Constructor
    public PotholeReport() {
    	if (lastReportID == 0) {
            lastReportID = getLastReportIDFromDatabase();
        }
        this.reportID = ++lastReportID;
        inputReportDetails();
        // Store the report into the database
        storeReport();
    }

    // Method to input report details from user
    private void inputReportDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Pothole Address: ");
        this.phAddress = scanner.nextLine();
        System.out.println("Enter Pothole Size (on a scale of 1 to 10): ");
        this.phSize = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("Enter Pothole Street Location (Middle, Left, Right, Curb, Turnlane): ");
        this.phStreetLocation = scanner.nextLine();
        System.out.println("Enter Pothole Repair Type (Asphalt, Concrete, Unknown): ");
        this.phRepairType = scanner.nextLine();
    }
	
	// Method to retrieve the last reportID from the database
    private int getLastReportIDFromDatabase() {
        int lastID = 0;
        // Database connection parameters
        String url = "jdbc:postgresql://104.196.171.217:5432/postgres";
        String user = "postgres";
        String password = "pothole";

        // SQL query to retrieve the last reportID
        String sql = "SELECT MAX(\"reportid\") FROM \"potholereport\"";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            // Check if there are results
            if (rs.next()) {
                lastID = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving last Citizen Report ID from database: " + e.getMessage());
        }

        return lastID;
    }

	// Other getter methods
	public int getReportID() {
		return reportID;
	}

	public String getPhAddress() {
		return phAddress;
	}

	public int getPhSize() {
		return phSize;
	}

	public String getPhStreetLocation() {
		return phStreetLocation;
	}

	public String getPhRepairType() {
		return phRepairType;
	}

	
    // Method to store report into the database
    private void storeReport() {
        // JDBC URL, user, and password of postgres server
        String url = "jdbc:postgresql://104.196.171.217:5432/postgres";
        String user = "postgres";
        String password = "pothole";

        // SQL query to insert data into PotholeReport table
        String insertSQL = "INSERT INTO \"potholereport\" (\"reportid\", \"streetloc\", \"address\", \"repairtype\", \"size\") VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {

            // Set parameters for the prepared statement
            preparedStatement.setInt(1, reportID);
            preparedStatement.setString(2, phStreetLocation);
            preparedStatement.setString(3, phAddress);
            preparedStatement.setString(4, phRepairType);
            preparedStatement.setInt(5, phSize);

            // Execute the query
            preparedStatement.executeUpdate();

            System.out.println("\nPothole Report stored in the database.");

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating a new PotholeReport object
        PotholeReport report = new PotholeReport();

        // Displaying report details
        System.out.println("\nPothole Report Details:");
        System.out.println("Citizen Report ID: " + report.getReportID());
        System.out.println("Address: " + report.getPhAddress());
        System.out.println("Size: " + report.getPhSize());
        System.out.println("Street Location: " + report.getPhStreetLocation());
        System.out.println("Repair Type: " + report.getPhRepairType());
    }
}
