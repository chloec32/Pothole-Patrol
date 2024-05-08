package PHTRS;
import java.sql.*;
import java.util.Scanner;


public class PotholeReport {
    private static int lastReportID;
    private static int ReportID;
    private static String StreetLoc;
    private static String Address;
    private static int Size;
    private static String RepType;

    // Constructor
    public PotholeReport() {
    	if (lastReportID == 0) {
            lastReportID = getLastReportIDFromDatabase();
        }
        this.ReportID = ++lastReportID;
        new GUI();
        // Store the report into the database
        storeReport();
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
	public static int getReportID() {
		return ReportID;
	}

	public static String getAddress() {
		return Address;
	}

	public static int getSize() {
		return Size;
	}

	public static String getStreetLoc() {
		return StreetLoc;
	}

	public static String getRepType() {
		return RepType;
	}


	public static void setPhAddress(String i) {
		Address = i;
	}

	public static void setPhSize(int i) {
		Size = i;
	}

	public static void setPhStreetLocation(String i) {
		StreetLoc = i;
	}

	public static void setPhRepairType(String i) {
		RepType = i;
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
            preparedStatement.setInt(1, ReportID);
            preparedStatement.setString(2, StreetLoc);
            preparedStatement.setString(3, Address);
            preparedStatement.setString(4, RepType);
            preparedStatement.setInt(5, Size);

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
        new GUI();
        // Displaying report details
        
    }
}
