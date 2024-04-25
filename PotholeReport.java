import java.util.Scanner;

public class PotholeReport {
    //private static int lastCitizenReportID = 0;
    //private int citizenReportID;
    // Changing citizenReportID to a general pothole ID based on the date, just gonna hardcode it for this sprint
    private int ReportID = 20240425001
    private String phStreetLocation;
    private String phAddress;
    private String phRepairType;
    private int phSize;
    
    // Constructor
    public PotholeReport() {
        //this.citizenReportID = ++lastCitizenReportID;
		inputReportDetails();
    }

	// Method to input report details from user
	private void inputReportDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Pothole Address: ");
		this.phAddress = scanner.nextLine();
		System.out.println("Enter Pothole Size (on a scale of 1 to 10): ");
		this.phSize = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		System.out.println("Enter Pothole Street Location (Middle, Left Right, Curb, Turnlane): ");
		this.phStreetLocation = scanner.nextLine();
		System.out.println("Enter Pothole Repair Type (asphalt, concrete, unknown): ");
		this.phRepairType = scanner.nextLine();
	}


	// Other getter methods
	public int getReportID() {
		return ReportID;
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


	// Main method for testing
    public static void main(String[] args) {
        // Creating a new PotholeReport object
        PotholeReport report = new PotholeReport();

		// Displaying report details
		System.out.println("\nPothole Report Details:");
		System.out.println("Citizen Report ID: " + report.getCitizenReportID());
		System.out.println("Address: " + report.getPhAddress());
		System.out.println("Size: " + report.getPhSize());
		System.out.println("Street Location: " + report.getPhStreetLocation());
		System.out.println("Repair Type: " + report.getPhRepairType());
		System.out.println("Priority: " + report.getPhPriority());
		System.out.println("Status: " + report.getPhStatus());
	}
}
