package PHTRS;
import java.util.Scanner;


public class WorkOrder{
	private int ReportID;
	private int RepPriority;
	private int EstRepairTime;
	private String RepairStatus;
	private String StreetLoc;
	private String Address;
	private String RepType;
	private int Size;

	Scanner scanner = new Scanner(System.in);
	  
	public WorkOrder(PotholeReport phReport) {
		this.ReportID = phReport.getReportID();
		this.StreetLoc = phReport.getStreetLoc();
		this.Address = phReport.getAddress();
		this.RepType = phReport.getRepType();
		this.Size = phReport.getSize();

		// Priority calculation based on size and location
		this.RepPriority = calculatePriority(Size);
		updateRepairTime();
		RepairStatus = "Not Started"; // Defaulted to not started 
	}

	public void updateRepairTime() {
		System.out.println("Enter Repair Time: ");
		this.EstRepairTime = scanner.nextInt();
		return;
	}
	public void updateStatus() {
		System.out.println("Enter Pothole Status (Not Started, In-Progress, Fixed): ");
		this.RepairStatus = scanner.nextLine();
	}

	// Method to calculate repair priority
	private int calculatePriority(int size) {
		// Calculation for priority
		int priority = size * 2; // basic calculation
		return priority;
	}
	
	public int getRepPriority(){
		return RepPriority;
	}
	
	public int getEstRepairTime(){
		return EstRepairTime;
	}
	
	public String getRepairStatus(){
		return RepairStatus;
	}

	
  
}  
