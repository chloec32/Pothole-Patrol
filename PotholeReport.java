import java.util.Scanner;

public class PotholeReport {
    private static int lastCitizenReportID = 0;
    private int citizenReportID;
    private String phAddress;
    private int phSize;
    private String phStreetLocation;
    private String phRepairType;
    private int phPriority;
    private String phStatus;

    // Constructor
    public PotholeReport() {
        this.citizenReportID = ++lastCitizenReportID;
		inputReportDetails();
		// Priority calculation based on size and location
		this.phPriority = calculatePriority(phSize, phStreetLocation);
		this.phStatus = "Reported"; // Initially set status to "Reported"
	}

	// Method to input report details from user
	private void inputReportDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Pothole Address: ");
		this.phAddress = scanner.nextLine();
		System.out.println("Enter Pothole Size (on a scale of 1 to 10): ");
		this.phSize = scanner.nextInt();
		scanner.nextLine(); // Consume newline character
		System.out.println("Enter Pothole Street Location: ");
		this.phStreetLocation = scanner.nextLine();
		System.out.println("Enter Pothole Repair Type (asphalt, concrete, unknown): ");
		this.phRepairType = scanner.nextLine();
	}

	// Method to calculate repair priority
	private int calculatePriority(int size, String location) {
		// Calculation for priority
		int priority = size * 2; // basic calculation
		return priority;
	}

	// Method to update status
	public void updateStatus(String status) {
		this.phStatus = status;
	}

	// Other getter methods
	public int getCitizenReportID() {
		return citizenReportID;
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

	public int getPhPriority() {
		return phPriority;
	}

	public String getPhStatus() {
		return phStatus;
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
