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
		this.ReportID = phReport.ReportID
		this.StreetLoc = phReport.StreetLoc
		this.Address = phReport.Address
		this.RepType = phReport.RepType
		this.Size = phReport.Size

		// Priority calculation based on size and location
		this.RepPriority = calculatePriority(Size);
		updateRepairTime();
		RepairStatus = "Not Started" // Defaulted to not started 
	}

	public updateRepairTime() {
		System.out.println("Enter Repair Time: ");
		this.EstRepairTime = scanner.nextLine();
	}
	public updateStatus() {
		System.out.println("Enter Pothole Status (Not Started, In-Progress, Fixed): ");
		this.RepairStatus = scanner.nextLine();
	}

	// Method to calculate repair priority
	private int calculatePriority(int size) {
		// Calculation for priority
		int priority = size * 2; // basic calculation
		return priority;
	}
	
	public getRepPriority(){
		return RepPriority;
	}
	
	public getEstRepairTime(){
		return EstRepairTime;
	}
	
	public getRepairStatus(){
		return RepairStatus;
	}

	
  
}  


    
